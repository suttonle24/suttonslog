package suttonsLog.domain.model;

/**
 * Created by leens on 3/8/2017.
 */
public class RecaptchaResponse {
    private boolean success;
    private String timestamp;
    private String hostname;

    public RecaptchaResponse() {}

    public RecaptchaResponse(boolean success, String timestamp, String hostname) {
        this.success = success;
        this.timestamp = timestamp;
        this.hostname = hostname;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
