define(['namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(suttonsLog, $, Handlebars) {
    suttonsLog.homepage.views.blotterView = function(blotter){
        if(blotter.success){
            $('#blotter').html(blotter.data);
        }
        else {
            $('#blotter').html('Error! - ' + blotter.xhr.statusText);
        }
    };
});