package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by leens on 3/9/2017.
 */
@Controller
public class CreateBlogController {
    @RequestMapping("/admin/create")
    public String loadLoginPage(Model model) {
        try {
            return "/create/index";
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "/create/index";
        }
    }
}
