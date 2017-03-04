package suttonsLog.domain.mapper;

import com.stormpath.sdk.authc.AuthenticationResult;
import suttonsLog.domain.model.AuthInfo;

/**
 * Created by leens on 3/3/2017.
 */
public class AuthMapper {
    public AuthInfo MapAuthResponse(AuthenticationResult authenticationResult){
        AuthInfo authInfo = new AuthInfo();

        try {
            authInfo.setEmail(authenticationResult.getAccount().getEmail());
            authInfo.setName(authenticationResult.getAccount().getFullName());

            return authInfo;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());

            return authInfo;
        }
    }
}
