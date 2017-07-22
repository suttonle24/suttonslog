package suttonsLog.domain.mapper;

import domain.model.dbo.UserDbo;
import suttonsLog.domain.model.AuthInfo;
import suttonsLog.domain.model.User;

/**
 * Created by leens on 3/3/2017.
 */
public class AuthMapper {
    public AuthInfo MapAuthResponse(User user){
        AuthInfo authInfo = new AuthInfo();

        try {
            authInfo.setEmail(user.getEmail());
            authInfo.setName(user.getName().getFirstName() + ' ' + user.getName().getLastName());

            return authInfo;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());

            return authInfo;
        }
    }
}
