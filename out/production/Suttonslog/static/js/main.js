$(document).ready(function(){
    $.ajax({
        type: 'GET',
        url: 'http://api.openweathermap.org/data/2.5/forecast/city?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831',
        dataType: 'json',
        success: function (data) {
            $('#weather').html('Weather in ' + data.city.name + '...');
        },
        error: function (xhr, status) {
            $('#weather').html('Error! - ' + xhr.statusText);
        }
    });

    $.ajax({
        type: 'GET',
        url: 'http://api.spotcrime.com/crimes.json?lat=47.372298&lon=-122.03258&radius=0.02&callback=jQuery2130688044759012147_1470334198788&key=1470334198794',
        dataType: 'json',
        success: function (data) {
            $('#blotter').html(data);
        },
        error: function (xhr, status) {
            $('#blotter').html('Error! - ' + xhr.statusText);
        }
    });
});