package suttonsLog;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

/**
 * Created by leens on 5/25/2017.
 */
@Configuration
public class StaticResourceConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        final String SLASH = System.getProperty("file.separator");
        try {
            // add mapping to blogPhotos upload directory
            String blogPhotosPath = new File(".").getCanonicalPath() + SLASH + "blogPhotos" + SLASH;
            String docsPath = new File(".").getCanonicalPath() + SLASH + "docs" + SLASH;

            if(SystemUtils.IS_OS_WINDOWS){
                blogPhotosPath = "file:///" + blogPhotosPath.replace("\\", "/");
                docsPath = "file:///" + docsPath.replace("\\", "/");
            }

            registry.addResourceHandler("/blogPhotos/**").addResourceLocations(blogPhotosPath);
            registry.addResourceHandler("/docs/**").addResourceLocations(docsPath);
        }
        catch (Exception e) {
            System.out.println("Exception while setting up mapped paths. Exception: " + e.getMessage());
        }
    }
}
