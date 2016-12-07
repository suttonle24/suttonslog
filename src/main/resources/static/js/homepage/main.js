requirejs.config({
    baseUrl:'./js',
    paths:{
        jquery: 'libs/jquery',
        handlebars: 'libs/Handlebars',
        hbsHelpers: 'homepage/hbsHelpers',
        mockjax: 'libs/mockjax',
        mocks: 'homepage/mocks',
        dataHandling: 'dataHandling',
        namespace: 'homepage/namespace',
        currentWeatherView: 'homepage/views/currentWeatherView',
        forecastView: 'homepage/views/forecastView',
        blotterView: 'homepage/views/blotterView',
        allBlogsView: 'homepage/views/allBlogsView'
    }
});

define(['dataHandling', 'namespace', 'jquery', 'handlebars', 'hbsHelpers',
        'currentWeatherView', 'forecastView', 'blotterView', 'allBlogsView'], function(dataHandling, suttonsLog, $, Handlebars) {
    suttonsLog.homepage.main = function(){
        if($('#mockData').val() === "true"){
            require(['mocks'], function(mocks){
                mocks.initMocks();
                suttonsLog.homepage.initPage();
            });
        }
        else {
            suttonsLog.homepage.initPage();
        }
    };

    suttonsLog.homepage.initPage = function(){

        var currentWeather = dataHandling.getData(
            'GET',
            'http://api.openweathermap.org/data/2.5/weather?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831',
            'currentWeather',
            suttonsLog.homepage.views.currentWeatherView
        );

        var forecast = dataHandling.getData(
            'GET',
            'http://api.openweathermap.org/data/2.5/forecast/city?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831',
            'forecast',
            suttonsLog.homepage.views.forecastView
        );

        var blotter = dataHandling.getData(
            'GET',
            'http://api.spotcrime.com/crimes.json?lat=47.372298&lon=-122.03258&radius=0.02&callback=jQuery2130688044759012147_1470334198788&key=1470334198794',
            'blotter',
            suttonsLog.homepage.views.blotterView
        );

        var allBlogs = dataHandling.getData(
            'GET',
            '/getAllBlogs.json',
            'allBlogs',
            suttonsLog.homepage.views.allBlogsView
        );
    };

    suttonsLog.homepage.main();
});



