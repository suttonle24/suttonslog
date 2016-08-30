/**
 * Created by leens on 8/30/2016.
 */
define('hbsHelpers', ['../libs/Handlebars'], function(Handlebars) {
    function getDate(dateTime) {
        var date = new Date(dateTime * 1000),
            dateString = date.toString(),
            dateStringParts = dateString.split(' ');

        return dateStringParts;
    }

    // date weekday[0] month[1] dayOfMonth[2] year[3]
    Handlebars.registerHelper('date-weekday', function (dateTime) {
        var date = getDate(dateTime);
        return date[0];
    });
    Handlebars.registerHelper('date-dayOfMonth', function (dateTime) {
        var date = getDate(dateTime);
        return date[2];
    });
    Handlebars.registerHelper('date-month', function (dateTime) {
        var date = getDate(dateTime);
        return date[1];
    });
    Handlebars.registerHelper('date-year', function (dateTime) {
        var date = getDate(dateTime);
        return date[3];
    });
    Handlebars.registerHelper('date-time', function (dateTime) {
        var date = getDate(dateTime),
            time = date[4];
        return time.substring(0, 5);
    });
    Handlebars.registerHelper('temperature', function (kelvin) {
        // Convert K to F.
        return Math.round(9 / 5 * (kelvin - 273) + 32);
    });

    Handlebars.registerHelper('weatherImg', function (filename) {

        switch (filename) {
            case '01d':
            case '01n':
                return '<img src="/images/weather/01d.png" />';
                break;
            case '02d':
            case '02n':
                return '<img src="/images/weather/02d.png" />';
                break;
            case '03d':
            case '03n':
                return '<img src="/images/weather/03d.png" />';
                break;
            case '04d':
            case '04n':
                return '<img src="/images/weather/04d.png" />';
                break;
            case '09d':
            case '09n':
                return '<img src="/images/weather/09d.png" />';
                break;
            case '10d':
            case '10n':
                return '<img src="/images/weather/10d.png" />';
                break;
            case '11d':
            case '11n':
                return '<img src="/images/weather/11d.png" />';
                break;
            case '13d':
            case '13n':
                return '<img src="/images/weather/13d.png" />';
                break;
            case '50d':
            case '50n':
                return '<img src="/images/weather/50d.png" />';
                break;
            default:
                break;
        }
    });
});