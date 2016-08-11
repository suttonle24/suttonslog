package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import suttonsLog.domain.model.BlogEntry;
import suttonsLog.domain.service.impl.BlogService;

/**
 * Created by leens on 7/20/2016.
 */
@Controller
public class HomepageController {

    @RequestMapping("/")
    public String loadBlogHomepage(Model model) {
        BlogService blogService = new BlogService();
        
        BlogEntry blogEntry = blogService.getLatestBlogEntry();

        model.addAttribute("blogTitle", blogEntry.getTitle());
        model.addAttribute("blogDate", blogEntry.getDatecreated());
        model.addAttribute("blogCategory", blogEntry.getCategory());
        model.addAttribute("blogAuthor", blogEntry.getAuthor());
        model.addAttribute("blogContent", blogEntry.getContents());

        return "index";
    }

}
