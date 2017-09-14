package domain.service.impl;

import domain.connector.ProjectConnector;
import domain.model.dbo.ProjectDbo;
import domain.model.response.ProjectResponse;
import domain.service.IProjectService;

import java.util.ArrayList;
import java.util.List;

public class ProjectService implements IProjectService {

    public ProjectResponse getProject(int sortOrder){
        ProjectDbo projectDbo = null;
        ProjectConnector connector = new ProjectConnector();

        projectDbo = connector.getProject(sortOrder);

        return new ProjectResponse(projectDbo, null, null);
    }

    public ProjectResponse getProjects() {
        ProjectConnector connector = new ProjectConnector();

        List<ProjectDbo> projects = connector.getProjects();

        return new ProjectResponse(projects, null, null);
    }

}
