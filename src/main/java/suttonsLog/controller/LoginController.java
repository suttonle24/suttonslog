package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import suttonsLog.domain.model.AuthInfo;
import suttonsLog.domain.model.AuthRequest;
import suttonsLog.domain.service.IAuthService;
import suttonsLog.domain.service.impl.AuthService;

/**
 * Created by leens on 12/9/2016.
 */
@Controller
public class LoginController {

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
    AuthInfo authenticate(AuthRequest authRequest) {
        try {
            IAuthService authService = new AuthService();

            return authService.getAuthentication(authRequest.getEmail(), authRequest.getPassword());
        }
        catch (Exception ex) {
            return null;
        }
    }
}
