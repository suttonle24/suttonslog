package suttonsLog.domain.service.impl;

import suttonsLog.domain.connector.ProjectConnector;
import suttonsLog.domain.model.Project;
import suttonsLog.domain.service.IProjectService;

import java.util.List;

public class ProjectService implements IProjectService {
    private ProjectConnector projectConnector = new ProjectConnector();
    public Project getProject(int sortOrder) {
        try {
            return projectConnector.getProject(sortOrder);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new Project();
        }
    }
    public List<Project> getProjects() {
        try {
            return projectConnector.getProjects();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
