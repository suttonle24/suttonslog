requirejs.config({
    baseUrl:'./js',
    paths:{
        jquery: 'libs/jquery',
        handlebars: 'libs/Handlebars',
        mockjax: 'libs/mockjax',
        dataHandling: 'dataHandling',
        namespace: 'portfolio/namespace',
        projectsView: 'portfolio/views/projectsView',
        jqueryCarousel: 'libs/jquery.carousel',
        waitForImages: 'libs/jquery.waitforimages.min'
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
        var projects = dataHandling.getData(
            'GET',
            '/getProjects.json',
            'projects',
            suttonsLog.portfolio.views.projectsView
        );


    };

    suttonsLog.portfolio.main();
});

