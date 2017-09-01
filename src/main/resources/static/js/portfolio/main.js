requirejs.config({
    baseUrl:'./js',
    paths:{
        jquery: 'libs/jquery',
        handlebars: 'libs/Handlebars',
        mockjax: 'libs/mockjax',
        dataHandling: 'dataHandling',
        namespace: 'portfolio/namespace',
        projectsView: 'portfolio/views/projectsView'
    }
});

define(['dataHandling', 'namespace', 'jquery', 'handlebars', 'hbsHelpers', 'projectsView'],
    function(dataHandling, suttonsLog, $, Handlebars) {
    suttonsLog.portfolio.main = function(){
        if($('#mockData').val() === "true"){
            require(['mocks'], function(mocks){
                mocks.initMocks();
                suttonsLog.portfolio.initPage();
            });
        }
        else {
            suttonsLog.portfolio.initPage();
        }
    };

    suttonsLog.portfolio.initPage = function(){


        // TODO - re-implement for getting a single project at a time...
        var projects = dataHandling.getData(
            'GET',
            'http://api.openweathermap.org/data/2.5/weather?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831',
            'currentWeather',
            suttonsLog.portfolio.views.projectsView
        );
    };

    suttonsLog.portfolio.main();
});

