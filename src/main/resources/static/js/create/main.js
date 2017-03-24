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
});