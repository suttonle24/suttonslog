package suttonsLog.domain.service.impl;

import suttonsLog.domain.connector.BlogEntryConnector;
import suttonsLog.domain.model.BlogEntry;
import suttonsLog.domain.service.IBlogService;

/**
 * Created by leens on 8/11/2016.
 */
public class BlogService implements IBlogService {
    private BlogEntryConnector blogEntryConnector = new BlogEntryConnector();

    public BlogEntry getLatestBlogEntry(){
        try{
            return blogEntryConnector.getLatestBlogEntry();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new BlogEntry();
        }
    }
}
