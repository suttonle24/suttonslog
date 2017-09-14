package suttonsLog.domain.connector;

import domain.model.response.ProjectResponse;
import domain.service.impl.ProjectService;
import suttonsLog.domain.mapper.ProjectResponseMapper;
import suttonsLog.domain.model.Project;

import java.util.ArrayList;
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
        try {
            ProjectResponse projectResponse = projectService.getProjects();
            List<Project> projects = projectResponseMapper.mapProjectsResponse(projectResponse);

            return projects;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
