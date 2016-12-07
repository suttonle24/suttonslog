define(['namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(suttonsLog, $, Handlebars) {
    suttonsLog.homepage.views.allBlogsView = function(allBlogs){
        if(allBlogs.success){
            var source   = $("#blogEntriesTemplate").html();
            var template = Handlebars.compile(source);
            $('#blogContainer').html(template(allBlogs.data));
        }
        else {
            console.log('Error! - ' + allBlogs.xhr.statusText);
        }
    };
});