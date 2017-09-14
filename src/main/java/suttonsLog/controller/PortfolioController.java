package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import suttonsLog.domain.model.Project;
import suttonsLog.domain.service.impl.ProjectService;

import java.util.List;

@Controller
public class PortfolioController {

    @RequestMapping("/portfolio")
    public String loadBlogHomepage() {
        return "/portfolio/index";
    }

    @RequestMapping(value="/getProjects.json", method= RequestMethod.GET)
    public @ResponseBody
    List<Project> getProjects() {
        ProjectService projectService = new ProjectService();

        return projectService.getProjects();
    }

}
