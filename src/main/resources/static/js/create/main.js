/**
 * Created by leens on 3/1/2017.
 */
requirejs.config({
    baseUrl:'../js',
    paths:{
        jquery: 'libs/jquery',
        handlebars: 'libs/Handlebars',
        mockjax: 'libs/mockjax',
        dataHandling: 'dataHandling',
        namespace: 'create/namespace',
        successView: 'create/views/successView',
        tinyMCE: 'libs/tinymce/tinymce.min'
    },
    shim: {
        tinyMCE: {
            exports: 'tinyMCE',
            init: function() {
                this.tinyMCE.DOM.events.domLoaded = true;
                return this.tinyMCE;
            }
        }
    }
});

define(['dataHandling', 'namespace', 'jquery', 'handlebars', 'tinyMCE'], function(dataHandling, suttonsLog, $, Handlebars, tinyMCE) {
//Add TinyMCE rich text editor
    //Add TinyMCE rich text editor
    tinyMCE.init({
        selector: "textarea",
        plugins: [
            "advlist autolink lists link image charmap print preview anchor",
            "searchreplace visualblocks code fullscreen",
            "insertdatetime media table contextmenu paste"
        ],
        toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
        style_formats: [
            {title: 'Headers', items: [
                {title: 'Header 1', format: 'h1'},
                {title: 'Header 2', format: 'h2'},
                {title: 'Header 3', format: 'h3'},
                {title: 'Header 4', format: 'h4'},
                {title: 'Header 5', format: 'h5'},
                {title: 'Header 6', format: 'h6'}
            ]},

            {title: 'Inline', items: [
                {title: 'Bold', icon: 'bold', format: 'bold'},
                {title: 'Italic', icon: 'italic', format: 'italic'},
                {title: 'Underline', icon: 'underline', format: 'underline'},
                {title: 'Strikethrough', icon: 'strikethrough', format: 'strikethrough'},
                {title: 'Superscript', icon: 'superscript', format: 'superscript'},
                {title: 'Subscript', icon: 'subscript', format: 'subscript'},
                {title: 'Code', icon: 'code', format: 'code'}
            ]},

            {title: 'Blocks', items: [
                {title: 'Paragraph', format: 'p'},
                {title: 'Blockquote', format: 'blockquote'},
                {title: 'Div', format: 'div'},
                {title: 'Pre', format: 'pre'}
            ]},

            {title: 'Alignment', items: [
                {title: 'Left', icon: 'alignleft', format: 'alignleft'},
                {title: 'Center', icon: 'aligncenter', format: 'aligncenter'},
                {title: 'Right', icon: 'alignright', format: 'alignright'},
                {title: 'Justify', icon: 'alignjustify', format: 'alignjustify'}
            ]},

            {title: 'Image Padding', items: [
                {title: 'Bottom', inline: 'span', classes: 'bottom'},
                {title: 'Bottom-Left', inline: 'span', classes: 'bottom-left'},
                {title: 'Bottom-Right', inline: 'span', classes: 'bottom-right'},
                {title: 'Middle-Left', inline: 'span', classes: 'middle-left'},
                {title: 'Middle-Right', inline: 'span', classes: 'middle-right'},
                {title: 'Top', inline: 'span', classes: 'top'},
                {title: 'Top-Left', inline: 'span', classes: 'top-left'},
                {title: 'Top-Right', inline: 'span', classes: 'top-right'}
            ]}
        ]
    });

    // Drag N' Drop uploader https://css-tricks.com/examples/DragAndDropFileUploading/
    // feature detection for drag&drop upload
    var isAdvancedUpload = function () {
        var div = document.createElement('div');
        return (('draggable' in div) || ('ondragstart' in div && 'ondrop' in div)) && 'FormData' in window && 'FileReader' in window;
    }();


    // applying the effect for every form
    var forms = document.querySelectorAll('.box');
    Array.prototype.forEach.call(forms, function (form) {
        var input = form.querySelector('input[type="file"]'),
            label = form.querySelector('label'),
            errorMsg = form.querySelector('.box__error span'),
            restart = form.querySelectorAll('.box__restart'),
            droppedFiles = false,
            showFiles = function (files) {
                label.textContent = files.length > 1 ? (input.getAttribute('data-multiple-caption') || '').replace('{count}', files.length) : files[0].name;
            },
            triggerFormSubmit = function () {
                var event = document.createEvent('HTMLEvents');
                event.initEvent('submit', true, false);
                form.dispatchEvent(event);
            };

        // letting the server side to know we are going to make an Ajax request
        var ajaxFlag = document.createElement('input');
        ajaxFlag.setAttribute('type', 'hidden');
        ajaxFlag.setAttribute('name', 'ajax');
        ajaxFlag.setAttribute('value', 1);
        form.appendChild(ajaxFlag);

        // automatically submit the form on file select
        input.addEventListener('change', function (e) {
            showFiles(e.target.files);


            triggerFormSubmit();


        });

        // drag&drop files if the feature is available
        if (isAdvancedUpload) {
            form.classList.add('has-advanced-upload'); // letting the CSS part to know drag&drop is supported by the browser

            ['drag', 'dragstart', 'dragend', 'dragover', 'dragenter', 'dragleave', 'drop'].forEach(function (event) {
                form.addEventListener(event, function (e) {
                    // preventing the unwanted behaviours
                    e.preventDefault();
                    e.stopPropagation();
                });
            });
            ['dragover', 'dragenter'].forEach(function (event) {
                form.addEventListener(event, function () {
                    form.classList.add('is-dragover');
                });
            });
            ['dragleave', 'dragend', 'drop'].forEach(function (event) {
                form.addEventListener(event, function () {
                    form.classList.remove('is-dragover');
                });
            });
            form.addEventListener('drop', function (e) {
                droppedFiles = e.dataTransfer.files; // the files that were dropped
                showFiles(droppedFiles);


                triggerFormSubmit();

            });
        }


        // if the form was submitted
        form.addEventListener('submit', function (e) {
            // preventing the duplicate submissions if the current one is in progress
            if (form.classList.contains('is-uploading')) return false;

            form.classList.add('is-uploading');
            form.classList.remove('is-error');

            if (isAdvancedUpload) // ajax file upload for modern browsers
            {
                e.preventDefault();

                // gathering the form data
                var ajaxData = new FormData(form);
                if (droppedFiles) {
                    Array.prototype.forEach.call(droppedFiles, function (file) {
                        ajaxData.append(input.getAttribute('name'), file);
                    });
                }

                // ajax request
                var ajax = new XMLHttpRequest();
                ajax.open(form.getAttribute('method'), form.getAttribute('action'), true);

                ajax.onload = function () {
                    form.classList.remove('is-uploading');
                    if (ajax.status >= 200 && ajax.status < 400) {
                        var data = JSON.parse(ajax.responseText);
                        form.classList.add(data.success == true ? 'is-success' : 'is-error');
                        if (!data.success) errorMsg.textContent = data.error;
                    }
                    else alert('Error. Please, contact the webmaster!');
                };

                ajax.onerror = function () {
                    form.classList.remove('is-uploading');
                    alert('Error. Please, try again!');
                };

                ajax.send(ajaxData);
            }
            else // fallback Ajax solution upload for older browsers
            {
                var iframeName = 'uploadiframe' + new Date().getTime(),
                    iframe = document.createElement('iframe');

                $iframe = $('<iframe name="' + iframeName + '" style="display: none;"></iframe>');

                iframe.setAttribute('name', iframeName);
                iframe.style.display = 'none';

                document.body.appendChild(iframe);
                form.setAttribute('target', iframeName);

                iframe.addEventListener('load', function () {
                    var data = JSON.parse(iframe.contentDocument.body.innerHTML);
                    form.classList.remove('is-uploading');
                    form.classList.add(data.success == true ? 'is-success' : 'is-error');
                    form.removeAttribute('target');
                    if (!data.success) errorMsg.textContent = data.error;
                    iframe.parentNode.removeChild(iframe);
                });
            }
        });


        // restart the form if has a state of error/success
        Array.prototype.forEach.call(restart, function (entry) {
            entry.addEventListener('click', function (e) {
                e.preventDefault();
                form.classList.remove('is-error', 'is-success');
                input.click();
            });
        });

        // Firefox focus bug fix for file input
        input.addEventListener('focus', function () { input.classList.add('has-focus'); });
        input.addEventListener('blur', function () { input.classList.remove('has-focus'); });

    });

    $('#submit').on('click', function(e){
        e.preventDefault();
        tinymce.get('contents').save();
        console.log('clickity click');
        submitBlog($(this));
    });

    submitBlog = function($submitBtn){
        $submitBtn.attr('disabled', 'disabled');

        var submitBlog = dataHandling.sendData(
            'post',
            '/submitPost.json',
            $('#blogForm').serializeArray(),
            'submitPost',
            suttonsLog.create.views.loginView
        );
    };
});