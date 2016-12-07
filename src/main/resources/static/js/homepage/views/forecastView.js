define(['namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(suttonsLog, $, Handlebars) {
    suttonsLog.homepage.views.forecastView = function(forecast){
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
});