package suttonsLog.controller;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import suttonsLog.domain.model.AuthInfo;
import suttonsLog.domain.model.AuthRequest;
import suttonsLog.domain.service.IAuthService;
import suttonsLog.domain.service.IRecaptchaService;
import suttonsLog.domain.service.impl.AuthService;
import suttonsLog.domain.service.impl.RecaptchaService;

import javax.json.JsonObject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by leens on 12/9/2016.
 */
@Controller
public class LoginController extends HttpServlet {

        @RequestMapping("/admin/login")
        public String loadLoginPage(Model model) {
            try {
                return "/login/index";
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
                model.addAttribute("authenticated", "Authentication failed.");
                return "/login/index";
            }
        }

    @RequestMapping(value="/authenticate.json", method= RequestMethod.POST)
    public @ResponseBody
    AuthInfo authenticate(AuthRequest authRequest, HttpServletRequest request) {
        try {
            IAuthService authService = new AuthService();
            IRecaptchaService recaptchaService = new RecaptchaService();

            JsonObject captchaResponse = recaptchaService.validateCaptcha(System.getenv("RECAPTCHA_SECRET_KEY"), authRequest.getGrecaptcharesponse(), null);

            if(captchaResponse.getBoolean("success")){
                AuthInfo authInfo = authService.getAuthentication(authRequest.getEmail(), authRequest.getPassword());
                if(authInfo.getName() != null) {
                    request.getSession().setAttribute("userName", authInfo.getName());
                    return authInfo;
                }
                else {
                    return null;
                }
            }
            else {
                return null;
            }
        }
        catch (Exception ex) {
            return null;
        }
    }


}
