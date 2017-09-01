package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {

    @RequestMapping("/portfolio")
    public String loadBlogHomepage() {
        return "/portfolio/index";
    }

}
