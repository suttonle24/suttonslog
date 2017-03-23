package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by leens on 3/9/2017.
 */
@Controller
public class CreateBlogController {
    @RequestMapping("/admin/create")
    public String loadLoginPage(Model model, HttpServletRequest request) {
        try {
            if(request.getSession().getAttribute("userName") != null){
                return "/create/index";
            }
            else {
                System.out.println("Not authorized!");
                return "/create/index";
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "/create/index";
        }
    }
}
