package suttonsLog.domain.connector;

import domain.model.dbo.BlogEntryDbo;
import domain.model.response.BlogEntryResponse;
import domain.service.impl.BlogEntryService;
import suttonsLog.domain.mapper.BlogEntryResponseMapper;
import suttonsLog.domain.model.BlogEntry;

/**
 * Created by leens on 8/11/2016.
 */
public class BlogEntryConnector {
    BlogEntryService blogEntryService = new BlogEntryService();
    BlogEntryResponseMapper blogEntryResponseMapper = new BlogEntryResponseMapper();

    public BlogEntry getLatestBlogEntry() {
        BlogEntry blogEntry = null;
        BlogEntryResponse blogEntryResponse = null;

        try {
            blogEntryResponse = blogEntryService.GetLatestBlogEntry();
            blogEntry = blogEntryResponseMapper.mapBlogEntryResponse(blogEntryResponse);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return blogEntry;
    }
}
