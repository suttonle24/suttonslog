package domain.service.impl;

import domain.connector.BlogEntryConnector;
import domain.model.dbo.BlogEntryDbo;
import domain.model.response.BlogEntryResponse;
import domain.service.IBlogEntryService;

/**
 * Created by leens on 8/10/2016.
 */
public class BlogEntryService implements IBlogEntryService {
    public BlogEntryResponse GetLatestBlogEntry(){
        BlogEntryDbo blogEntryDbo = null;
        BlogEntryConnector connector = new BlogEntryConnector();

        blogEntryDbo = connector.getLatestBlogEntry();

        return new BlogEntryResponse(blogEntryDbo, null, null);
    }
}
