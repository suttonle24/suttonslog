package suttonsLog.domain.connector;

import domain.model.response.UserResponse;
import domain.service.impl.UserService;
import suttonsLog.domain.mapper.UserMapper;
import suttonsLog.domain.model.User;

public class UserConnector {
    private UserService userService = new UserService();
    private UserMapper userMapper = new UserMapper();
    public User getUser(String username){
        User user = null;
        UserResponse userResponse = null;

        try{
            userResponse = userService.getUser(username);
            user = userMapper.mapUser(userResponse.getUserDbo());
        }
        catch(Exception e){

        }
        return user;
    }
}
