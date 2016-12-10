package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by leens on 12/9/2016.
 */
@Controller
public class CreateController {

    @RequestMapping("/admin/create")
    public String loadBlogCreationPage() {
        return "/create/index";
    }
}
