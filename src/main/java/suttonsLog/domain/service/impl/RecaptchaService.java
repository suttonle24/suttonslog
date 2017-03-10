package suttonsLog.domain.service.impl;

import suttonsLog.domain.service.IRecaptchaService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by leens on 3/10/2017.
 */
public class RecaptchaService implements IRecaptchaService {
    public JsonObject validateCaptcha(String secret, String response, String remoteip)
    {
        JsonObject jsonObject = null;
        URLConnection connection = null;
        InputStream is = null;
        String charset = java.nio.charset.StandardCharsets.UTF_8.name();

        String url = "https://www.google.com/recaptcha/api/siteverify";
        try {
            String query = String.format("secret=%s&response=%s",
                    URLEncoder.encode(secret, charset),
                    URLEncoder.encode(response, charset));

            connection = new URL(url + "?" + query).openConnection();
            is = connection.getInputStream();
            JsonReader rdr = Json.createReader(is);
            jsonObject = rdr.readObject();

        }
        catch (Exception ex) {
            return null;
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }

            }
        }
        return jsonObject;
    }
}
