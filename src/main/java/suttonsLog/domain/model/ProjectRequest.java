package suttonsLog.domain.model;

public class ProjectRequest {
    private int sortOrder;

    public ProjectRequest() {
    }

    public ProjectRequest(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }
}
