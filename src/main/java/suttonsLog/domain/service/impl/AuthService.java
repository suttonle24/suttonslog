package suttonsLog.domain.service.impl;

import com.stormpath.sdk.api.ApiKey;
import com.stormpath.sdk.api.ApiKeys;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.authc.AuthenticationRequest;
import com.stormpath.sdk.authc.AuthenticationResult;
import com.stormpath.sdk.authc.UsernamePasswordRequests;
import com.stormpath.sdk.client.Client;
import com.stormpath.sdk.client.Clients;
import suttonsLog.domain.mapper.AuthMapper;
import suttonsLog.domain.model.AuthInfo;
import suttonsLog.domain.service.IAuthService;

/**
 * Created by leens on 3/3/2017.
 */
public class AuthService implements IAuthService {
    public AuthInfo getAuthentication(String email, String password){
        AuthMapper authMapper = new AuthMapper();

        ApiKey apiKey = ApiKeys.builder().setFileLocation(System.getenv("STORMPATH_API_KEY")).build();

        Client client = Clients.builder().setApiKey(apiKey).setBaseUrl(System.getenv("STORMPATH_BASE_URL")).build();
        Application application = client.getResource(System.getenv("STORMPATH_APPLICATION_HREF"), Application.class);

        AuthenticationRequest request = UsernamePasswordRequests.builder()
                .setUsernameOrEmail(email)
                .setPassword(password)
                .build();

        AuthenticationResult authenticationResult = application.authenticateAccount(request);

        return authMapper.MapAuthResponse(authenticationResult);
    }
}
