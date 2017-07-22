package suttonsLog.domain.service.impl;

import suttonsLog.domain.connector.UserConnector;
import suttonsLog.domain.model.User;

public class UserService {
    private UserConnector userConnector = new UserConnector();
    public User getUser(String username){
        try{
            return userConnector.getUser(username);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new User();
        }
    }
}
