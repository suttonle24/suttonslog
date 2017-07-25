package domain.service.impl;

import domain.connector.BlogEntryConnector;
import domain.model.dbo.BlogEntryDbo;
import domain.model.response.BlogEntryResponse;
import domain.service.IBlogEntryService;

import java.util.List;

/**
 * Created by leens on 8/10/2016.
 */
public class BlogEntryService implements IBlogEntryService {
    public BlogEntryResponse getLatestBlogEntry(){
        BlogEntryDbo blogEntryDbo = null;
        BlogEntryConnector connector = new BlogEntryConnector();

        blogEntryDbo = connector.getLatestBlogEntry();

        return new BlogEntryResponse(blogEntryDbo, null, null);
    }

    public BlogEntryResponse getAllBlogEntries(){
        List<BlogEntryDbo> allBlogEntries = null;
        BlogEntryConnector connector = new BlogEntryConnector();

        allBlogEntries = connector.getAllBlogEntries();

        return new BlogEntryResponse(allBlogEntries, null, null);
    }

    public BlogEntryResponse createBlogEntry(BlogEntryDbo blogEntryDbo){
        BlogEntryConnector connector = new BlogEntryConnector();
        BlogEntryResponse response = new BlogEntryResponse();

        boolean createSuccess = connector.createBlogEntry(blogEntryDbo);

        response.setSuccessful(createSuccess);

        if(!createSuccess){
            response.setErrorMessage("Save failed.");
        }

        return response;
    }
}
