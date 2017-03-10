package suttonsLog.domain.service;

import javax.json.JsonObject;

/**
 * Created by leens on 3/10/2017.
 */
public interface IRecaptchaService {
    public JsonObject validateCaptcha(String secret, String response, String remoteip);
}
