package suttonsLog.domain.service.impl;

import com.mongodb.*;
import domain.model.dbo.UserDbo;
import org.mongojack.JacksonDBCollection;
import suttonsLog.domain.mapper.AuthMapper;
import suttonsLog.domain.model.AuthInfo;
import suttonsLog.domain.model.User;
import suttonsLog.domain.service.IAuthService;

/**
 * Created by leens on 3/3/2017.
 */
public class AuthService implements IAuthService {
    public AuthInfo getAuthentication(String username, String password){
        AuthMapper authMapper = new AuthMapper();
        UserService userService = new UserService();

        try {
            User user = userService.getUser(username);

            if(user != null) {
                if(user.getPassword().equals(password)){
                    System.out.print("Yay!");
                    return authMapper.MapAuthResponse(user);
                }
                else {
                    System.out.print("Boo!");
                    return authMapper.MapAuthResponse(new User());
                }
            }
            else {
                return authMapper.MapAuthResponse(new User());
            }
        }
        catch (Exception e) {
            return authMapper.MapAuthResponse(new User());
        }
    }
}
