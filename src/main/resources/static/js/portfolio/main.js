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

define(['dataHandling', 'namespace', 'jquery', 'handlebars', 'projectsView'],
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
            'POST',
            '/getProjects.json',
            'projects',
            suttonsLog.portfolio.views.projectsView
        );
    };

    suttonsLog.portfolio.main();
});

