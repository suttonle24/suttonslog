/**
 * Created by leens on 3/1/2017.
 */
requirejs.config({
    baseUrl:'../js',
    paths:{
        jquery: 'libs/jquery',
        handlebars: 'libs/Handlebars',
        hbsHelpers: 'homepage/hbsHelpers',
        mockjax: 'libs/mockjax',
        mocks: 'login/mocks',
        dataHandling: 'dataHandling',
        namespace: 'login/namespace',
        loginView: 'login/views/loginView'
    }
});

define(['dataHandling', 'namespace', 'jquery', 'handlebars', 'hbsHelpers', 'loginView'], function(dataHandling, suttonsLog, $, Handlebars) {

    $('#submit').on('click', function(){
        console.log('hello!');
        var login = dataHandling.sendData(
            'post',
            '/authenticate.json',
            $('#loginForm').serializeArray(),
            'login',
            suttonsLog.login.views.loginView
        );
    });

});