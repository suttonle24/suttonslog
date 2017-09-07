package suttonsLog.domain.connector;

import domain.model.response.ProjectResponse;
import domain.service.impl.ProjectService;
import suttonsLog.domain.mapper.ProjectResponseMapper;
import suttonsLog.domain.model.Project;

import java.util.List;

public class ProjectConnector {
    ProjectService projectService = new ProjectService();
    ProjectResponseMapper projectResponseMapper = new ProjectResponseMapper();

    public Project getProject(int sortOrder) {
        Project project = null;
        ProjectResponse projectResponse = null;

        try {
            projectResponse = projectService.getProject(sortOrder);
            project = projectResponseMapper.mapProjectResponse(projectResponse);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return project;
    }

    public List<Project> getProjects() {
        List<Project> projects = null;
        ProjectResponse projectResponse = null;

        try {
            projectResponse = projectService.getProjects();
            projects = projectResponseMapper.mapProjectsResponse(projectResponse);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return projects;
    }
}
