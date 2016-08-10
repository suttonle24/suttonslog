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
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        BlogEntryService blogEntryService = new BlogEntryService();

        BlogEntryResponse response = blogEntryService.GetLatestBlogEntry();

        model.addAttribute("blogContent", response.getBlogEntryDbo().getContents());

        model.addAttribute("name", name);
        return "index";
    }

}
