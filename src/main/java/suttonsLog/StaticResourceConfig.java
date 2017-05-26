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
        String slash = System.getProperty("file.separator");
        String path;
        try {
            // add mapping to blogPhotos upload directory
            path = new File(".").getCanonicalPath() + slash + "blogPhotos" + slash;

            if(SystemUtils.IS_OS_WINDOWS){
                path = "file:///" + path.replace("\\", "/");
            }
        }
        catch (Exception e) {
            path = "borked";
        }
        registry.addResourceHandler("/blogPhotos/**").addResourceLocations(path);
    }
}
