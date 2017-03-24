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
        namespace: 'create/namespace'
    }
});

define(['dataHandling', 'namespace', 'jquery', 'handlebars'], function(dataHandling, suttonsLog, $, Handlebars) {
    
});