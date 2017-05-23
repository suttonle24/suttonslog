package suttonsLog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import suttonsLog.model.PhotoUploadResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.InputStream;
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

    @RequestMapping(value = "/uploadPhotos", method = RequestMethod.POST)
    public @ResponseBody
    PhotoUploadResponse uploadPhotos(HttpServletRequest request){
        try {
            List<Part> fileParts = request.getParts().stream().filter(part -> "files[]".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
            String response = "";
            for (Part filePart : fileParts) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                InputStream fileContent = filePart.getInputStream();

                if(fileName.length() > 0){
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
