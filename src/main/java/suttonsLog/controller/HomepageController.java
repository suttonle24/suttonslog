package suttonsLog.controller;

import domain.model.response.BlogEntryResponse;
import domain.service.impl.BlogEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by leens on 7/20/2016.
 */
@Controller
public class HomepageController {

    @RequestMapping("/")
    public String loadBlogHomepage(Model model) {

        BlogEntryService blogEntryService = new BlogEntryService();

        BlogEntryResponse response = blogEntryService.GetLatestBlogEntry();

        model.addAttribute("blogId", response.getBlogEntryDbo().getId());
        model.addAttribute("blogTitle", response.getBlogEntryDbo().getTitle());
        model.addAttribute("blogDate", response.getBlogEntryDbo().getDatecreated());
        model.addAttribute("blogCategory", response.getBlogEntryDbo().getCategory());
        model.addAttribute("blogAuthor", response.getBlogEntryDbo().getAuthor());
        model.addAttribute("blogContent", response.getBlogEntryDbo().getContents());

        return "index";
    }

}
