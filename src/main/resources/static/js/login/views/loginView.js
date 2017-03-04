/**
 * Created by leens on 3/1/2017.
 */
define(['namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(suttonsLog, $, Handlebars) {
    suttonsLog.login.views.loginView = function(login){
        if(login){
            var source   = $("#loginTemplate").html();
            var template = Handlebars.compile(source);
            $('#loginView').html(template(login));
        }
        else {
            console.log('Error! - ' + allBlogs.xhr.statusText);
        }
    };
});