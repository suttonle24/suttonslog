package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import suttonsLog.domain.model.BlogEntry;
import suttonsLog.domain.service.impl.BlogService;
import suttonsLog.model.BlogSubmissionResponse;
import suttonsLog.model.PhotoUploadResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by leens on 3/9/2017.
 */
@Controller
public class CreateBlogController extends HttpServlet {
    @RequestMapping("/admin/create")
    public String loadLoginPage(Model model, HttpServletRequest request) {
        try {
            if(request.getSession().getAttribute("userName") != null){
                return "/create/index";
            }
            else {
                return "/create/forbidden";
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "/create/index";
        }
    }

    @RequestMapping(value="/submitPost.json", method= RequestMethod.POST)
    public @ResponseBody
    BlogSubmissionResponse submitBlogPost(BlogEntry blogEntry) {
        BlogService blogService = new BlogService();

        boolean response = blogService.createBlogEntry(blogEntry);


        return new BlogSubmissionResponse(response);
    }

    @RequestMapping(value = "/uploadPhotos", method = RequestMethod.POST)
    public @ResponseBody
    PhotoUploadResponse uploadPhotos(HttpServletRequest request){
        try {
            // TODO - migrate to service.
            String slash = System.getProperty("file.separator");
            String path = new File(".").getCanonicalPath() + slash + "blogPhotos" + slash;
            List<Part> fileParts = request.getParts().stream().filter(part -> "files[]".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
            String response = "";
            for (Part filePart : fileParts) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.

                if(fileName.length() > 0){
                    filePart.write(path + fileName);
                    response += ", " + fileName;
                }
            }

            if(!response.equals("")){
                return new PhotoUploadResponse(true, response);
            }
            else {
                return new PhotoUploadResponse(false, "boo");
            }
        }
        catch(Exception e) {
            return new PhotoUploadResponse(false, e.getMessage());
        }

    }
}
