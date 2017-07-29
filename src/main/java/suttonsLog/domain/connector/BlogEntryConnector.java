package suttonsLog.domain.connector;

import domain.model.response.BlogEntryResponse;
import domain.service.impl.BlogEntryService;
import suttonsLog.domain.mapper.BlogEntryResponseMapper;
import suttonsLog.domain.mapper.BlogMapper;
import suttonsLog.domain.model.BlogEntry;
import suttonsLog.domain.model.BlogEntryCreateResponse;

import java.util.LinkedList;
import java.util.List;

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
            blogEntryResponse = blogEntryService.getLatestBlogEntry();
            blogEntry = blogEntryResponseMapper.mapBlogEntryResponse(blogEntryResponse);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return blogEntry;
    }

    public List<BlogEntry> getAllBlogEntries() {
        List<BlogEntry> blogEntries = new LinkedList<BlogEntry>();
        BlogEntryResponse blogEntryResponse = null;

        try {
            blogEntryResponse = blogEntryService.getAllBlogEntries();
            blogEntries = blogEntryResponseMapper.mapBlogEntryListResponse(blogEntryResponse);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return blogEntries;
    }

    public boolean createBlogEntry(BlogEntry blogEntry) {
        BlogMapper blogMapper = new BlogMapper();
        BlogEntryResponse blogEntryResponse = null;
        blogEntryResponse = blogEntryService.createBlogEntry(blogMapper.blogEntryToDbo(blogEntry));

        if(blogEntryResponse.getSuccessful()){
            return true;
        }
        else {
            return false;
        }
    }
}
