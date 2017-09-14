package suttonsLog.domain.mapper;

import domain.model.dbo.ProjectDbo;
import domain.model.response.ProjectResponse;
import suttonsLog.domain.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectResponseMapper {
    public Project mapProjectResponse(ProjectResponse projectResponse) {

        return mapProject(projectResponse.getProjectDbo());
    }

    public List<Project> mapProjectsResponse(ProjectResponse projectResponse) {
        List<Project> projects = new ArrayList<>();

        for(ProjectDbo projectDbo : projectResponse.getProjectDbos()) {
            projects.add(mapProject(projectDbo));
        }

        return projects;
    }

    private Project mapProject(ProjectDbo projectDbo) {
        Project project = new Project();

        try {
            project.setBannerAlt(projectDbo.getBanner_alt());
            project.setBannerImg(projectDbo.getBanner_img());
            project.setContentLink(projectDbo.getContent_link());
            project.setSortOrder(projectDbo.getSort_order());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return project;
    }
}
