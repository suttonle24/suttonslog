package domain.service.impl;

import domain.connector.UserConnector;
import domain.model.dbo.UserDbo;
import domain.model.response.UserResponse;

public class UserService {
    public UserResponse getUser(String username){
        UserDbo userDbo = null;
        UserConnector connector = new UserConnector();

        userDbo = connector.getUser(username);

        return new UserResponse(userDbo, true, null);
    }
}
