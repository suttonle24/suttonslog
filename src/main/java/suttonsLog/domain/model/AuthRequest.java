package suttonsLog.domain.model;

/**
 * Created by leens on 3/3/2017.
 */

public class AuthRequest {
    private String username;
    private String password;
    private String grecaptcharesponse;

    public AuthRequest() {}

    public AuthRequest(String username, String password, String grecaptcharesponse) {
        this.username = username;
        this.password = password;
        this.grecaptcharesponse = grecaptcharesponse;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrecaptcharesponse() {
        return grecaptcharesponse;
    }

    public void setGrecaptcharesponse(String grecaptcharesponse) {
        this.grecaptcharesponse = grecaptcharesponse;
    }
}
