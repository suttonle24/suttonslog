package suttonsLog.model;

/**
 * Created by leens on 5/22/2017.
 */
public class PhotoUploadResponse {
    private boolean success;
    private String response;

    public PhotoUploadResponse(boolean success) {
        this.success = success;
    }

    public PhotoUploadResponse(boolean success, String response) {
        this.success = success;
        this.response = response;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
