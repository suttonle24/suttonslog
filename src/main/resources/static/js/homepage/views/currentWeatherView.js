define(['namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(suttonsLog, $, Handlebars) {
    suttonsLog.homepage.views.currentWeatherView = function(currentWeather){
        if(currentWeather.success){
            var source   = $("#weatherCurrentTemplate").html();
            var template = Handlebars.compile(source);
            $('#weather .current').html(template(currentWeather.data));
        }
        else {
            $('#weather .current').html('Error! - ' + currentWeather.xhr.statusText);
        }
    };
});