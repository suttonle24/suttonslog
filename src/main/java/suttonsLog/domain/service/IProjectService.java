package suttonsLog.domain.service;

import suttonsLog.domain.model.Project;

import java.util.List;

public interface IProjectService {
    public Project getProject(int sortOrder);
    public List<Project> getProjects();
}
