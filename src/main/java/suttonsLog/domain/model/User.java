package suttonsLog.domain.model;

public class User {
    private String email;
    private String username;
    private String password;
    private FullName name;

    public User(){}

    public User(String email, String username, String password, FullName name) {
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
