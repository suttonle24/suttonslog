/**
 * Created by leens on 3/1/2017.
 */
define(['namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(suttonsLog, $, Handlebars) {
    suttonsLog.login.views.loginView = function(login){
        if(login){
            var source   = $("#loginTemplate").html();
            var template = Handlebars.compile(source);
            $('#loginView').addClass('complete').html(template(login));

            setTimeout(function(){
                $('#redirectMsg').show();
                if(!login.data) {
                    $('#submit').removeAttr('disabled');
                }
                else {
                    setTimeout(function(){
                        window.location.href = '/admin/create';
                    },500);
                }
            }, 750);
        }
        else {
            console.log('Error! - ' + allBlogs.xhr.statusText);
        }
    };
});