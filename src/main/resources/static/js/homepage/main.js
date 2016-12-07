requirejs.config({
    baseUrl:'./js',
    paths:{
        jquery: 'libs/jquery',
        handlebars: 'libs/Handlebars',
        hbsHelpers: 'homepage/hbsHelpers',
        dataHandling: 'dataHandling',
        namespace: 'homepage/namespace',
        mockjax: 'libs/mockjax',
        mocks: 'homepage/mocks'
    }
});

define(['dataHandling', 'namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(dataHandling, suttonsLog, $, Handlebars) {
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
            suttonsLog.homepage.currentWeatherCallback
        );

        var forecast = dataHandling.getData(
            'GET',
            'http://api.openweathermap.org/data/2.5/forecast/city?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831',
            'forecast',
            suttonsLog.homepage.forecastCallback
        );

        var blotter = dataHandling.getData(
            'GET',
            'http://api.spotcrime.com/crimes.json?lat=47.372298&lon=-122.03258&radius=0.02&callback=jQuery2130688044759012147_1470334198788&key=1470334198794',
            'blotter',
            suttonsLog.homepage.blotterCallback
        );

        var allBlogs = dataHandling.getData(
            'GET',
            '/getAllBlogs.json',
            'allBlogs',
            suttonsLog.homepage.allBlogsCallback
        );
    };

    suttonsLog.homepage.currentWeatherCallback = function(currentWeather){
        if(currentWeather.success){
            var source   = $("#weatherCurrentTemplate").html();
            var template = Handlebars.compile(source);
            $('#weather .current').html(template(currentWeather.data));
        }
        else {
            $('#weather .current').html('Error! - ' + currentWeather.xhr.statusText);
        }
    };

    suttonsLog.homepage.forecastCallback = function(forecast){
        if(forecast.success){
            var source   = $("#weatherForecastTemplate").html();
            var template = Handlebars.compile(source);
            $('#weather .forecast .list').html(template(forecast.data));

            var listWidth = 0;
            $('#weather .forecast .list .day').each(function() {
                listWidth += $(this).outerWidth();
            });
            $('#weather .forecast .list').width(listWidth);
        }
        else {
            $('#weather .forecast').html('Error! - ' + forecast.xhr.statusText);
        }
    };

    suttonsLog.homepage.blotterCallback = function(blotter){
        if(blotter.success){
            $('#blotter').html(blotter.data);
        }
        else {
            $('#blotter').html('Error! - ' + blotter.xhr.statusText);
        }
    };

    suttonsLog.homepage.allBlogsCallback = function(allBlogs){
        if(allBlogs.success){
            var source   = $("#blogEntriesTemplate").html();
            var template = Handlebars.compile(source);
            $('#blogContainer').html(template(allBlogs.data));
        }
        else {
            console.log('Error! - ' + allBlogs.xhr.statusText);
        }
    };

    suttonsLog.homepage.main();
});



