package domain.model.response;

import domain.model.dbo.ProjectDbo;

import java.util.List;

public class ProjectResponse {
    private ProjectDbo projectDbo;
    private List<ProjectDbo> projectDbos;
    private Boolean successful;
    private String errorMessage;

    public ProjectResponse(){}

    public ProjectResponse(ProjectDbo projectDbo, Boolean successful, String errorMessage) {
        this.projectDbo = projectDbo;
        this.successful = successful;
        this.errorMessage = errorMessage;
    }

    public ProjectResponse(List<ProjectDbo> projectDbos, Boolean successful, String errorMessage) {
        this.projectDbos = projectDbos;
        this.successful = successful;
        this.errorMessage = errorMessage;
    }

    public ProjectDbo getProjectDbo() {
        return projectDbo;
    }

    public void setProjectDbo(ProjectDbo projectDbo) {
        this.projectDbo = projectDbo;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<ProjectDbo> getProjectDbos() {
        return projectDbos;
    }
}
