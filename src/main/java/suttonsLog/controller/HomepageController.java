package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import suttonsLog.domain.model.BlogEntry;
import suttonsLog.domain.service.impl.BlogService;

/**
 * Created by leens on 7/20/2016.
 */
@Controller
public class HomepageController {

    @RequestMapping("/")
    public String loadBlogHomepage(Model model) {
        return "index";
    }

    @RequestMapping(value="/getLatestBlog.json", method= RequestMethod.GET)
    public @ResponseBody
    BlogEntry getLatestBlog() {
        BlogService blogService = new BlogService();

        return blogService.getLatestBlogEntry();
    }

}
