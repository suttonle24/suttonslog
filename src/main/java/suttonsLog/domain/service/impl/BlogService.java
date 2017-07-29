package suttonsLog.domain.service.impl;

import suttonsLog.domain.connector.BlogEntryConnector;
import suttonsLog.domain.model.BlogEntry;
import suttonsLog.domain.model.BlogEntryCreateResponse;
import suttonsLog.domain.service.IBlogService;

import java.util.List;

/**
 * Created by leens on 8/11/2016.
 */
public class BlogService implements IBlogService {
    private BlogEntryConnector blogEntryConnector = new BlogEntryConnector();

    public boolean createBlogEntry(BlogEntry blogEntry){
        try {
            return blogEntryConnector.createBlogEntry(blogEntry);
        }
        catch(Exception e) {
            return false;
        }
    }

    public BlogEntry getLatestBlogEntry(){
        try{
            return blogEntryConnector.getLatestBlogEntry();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new BlogEntry();
        }
    }

    public List<BlogEntry> getAllBlogEntries(){
        try{
            return blogEntryConnector.getAllBlogEntries();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
