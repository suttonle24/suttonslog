define(['namespace', 'jquery', 'handlebars', 'hbsHelpers'], function(suttonsLog, $, Handlebars) {
    suttonsLog.portfolio.views.projectsView = function(projects){
        if(projects.success){
            var source   = $("#projectsTemplate").html();
            var template = Handlebars.compile(source);
            $('#projectsContainer').html(template(projects.data));
        }
        else {
            console.log('Error! - ' + projects.xhr.statusText);
        }
    };
});