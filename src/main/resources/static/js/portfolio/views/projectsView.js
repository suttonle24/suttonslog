define(['namespace', 'jquery', 'handlebars'], function(suttonsLog, $, Handlebars) {
    suttonsLog.portfolio.views.projectsView = function(projects){
        if(projects.success){
            var source   = $("#projectTemplate").html();
            var template = Handlebars.compile(source);
            $('#projectsContainer').html(template(projects.data));
        }
        else {
            console.log('Error! - ' + projects.xhr.statusText);
        }
    };
});