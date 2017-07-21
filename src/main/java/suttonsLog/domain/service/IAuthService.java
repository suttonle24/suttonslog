package suttonsLog.domain.service;

import suttonsLog.domain.model.AuthInfo;

/**
 * Created by leens on 3/3/2017.
 */
public interface IAuthService {
    AuthInfo getAuthentication(String username, String password);
}
