package suttonsLog.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by leens on 3/3/2017.
 */

public class AuthRequest {
    private String email;
    private String password;
    private String grecaptcharesponse;

    public AuthRequest() {}

    public AuthRequest(String email, String password, String grecaptcharesponse) {
        this.email = email;
        this.password = password;
        this.grecaptcharesponse = grecaptcharesponse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
