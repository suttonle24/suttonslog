package domain.model.response;

import domain.model.dbo.UserDbo;

public class UserResponse {
    private UserDbo userDbo;
    private boolean successful;
    private String errorMessage;

    public UserResponse() {
    }

    public UserResponse(UserDbo userDbo) {
        this.userDbo = userDbo;
    }

    public UserResponse(UserDbo userDbo, boolean successful, String errorMessage) {
        this.userDbo = userDbo;
        this.successful = successful;
        this.errorMessage = errorMessage;
    }

    public UserResponse(boolean successful, String errorMessage) {
        this.successful = successful;
        this.errorMessage = errorMessage;
    }

    public UserDbo getUserDbo() {
        return userDbo;
    }

    public void setUserDbo(UserDbo userDbo) {
        this.userDbo = userDbo;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
