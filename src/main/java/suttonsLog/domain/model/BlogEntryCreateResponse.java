package suttonsLog.domain.model;

/**
 * Created by leens on 5/28/2017.
 */
public class BlogEntryCreateResponse {
    private boolean success;

    public BlogEntryCreateResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
