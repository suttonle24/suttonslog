define('main', ['../libs/jquery', '../libs/Handlebars', 'hbsHelpers'], function(jQuery, Handlebars) {

    window.initPage = function(){


        $.ajax({
            type: 'GET',
            url: 'http://api.openweathermap.org/data/2.5/weather?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831',
            dataType: 'json',
            success: function (data) {
                var source   = $("#weatherCurrentTemplate").html();
                var template = Handlebars.compile(source);
                $('#weather .current').html(template(data));
            },
            error: function (xhr, status) {
                $('#weather .current').html('Error! - ' + xhr.statusText);
            }
        });

        $.ajax({
            type: 'GET',
            url: 'http://api.openweathermap.org/data/2.5/forecast/city?id=5802340&APPID=b5928ee8c96cf5f4fac7f4cf6098f831',
            dataType: 'json',
            success: function (data) {
                var source   = $("#weatherForecastTemplate").html();
                var template = Handlebars.compile(source);
                $('#weather .forecast .list').html(template(data));

                var listWidth = 0;
                $('#weather .forecast .list .day').each(function() {
                    listWidth += $(this).outerWidth();
                });
                $('#weather .forecast .list').width(listWidth);
            },
            error: function (xhr, status) {
                $('#weather .forecast').html('Error! - ' + xhr.statusText);
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

        $.ajax({
            type: 'GET',
            url: '/getAllBlogs.json',
            dataType: 'json',
            success: function (data) {
                var source   = $("#blogEntriesTemplate").html();
                var template = Handlebars.compile(source);
                $('#blogContainer').html(template(data));
            },
            error: function (xhr, status) {
                console.log('Error! - ' + xhr.statusText);
            }
        });
    };



    if($('#mockData').val() === "true"){
        require(['mocks'], function(){
            initMocks();
        });
        initPage();
    }
    else {
        initPage();
    }
});



