package suttonsLog.model;

/**
 * Created by leens on 5/28/2017.
 */
public class BlogSubmissionResponse {
    private boolean success;

    public BlogSubmissionResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
