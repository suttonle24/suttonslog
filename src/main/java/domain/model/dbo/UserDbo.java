package domain.model.dbo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import domain.model.valueObject.FullName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDbo {
    private String email;
    private String username;
    private String password;
    private FullName name;

    public UserDbo(){}

    public UserDbo(String email, String username, String password, FullName name) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }
}
