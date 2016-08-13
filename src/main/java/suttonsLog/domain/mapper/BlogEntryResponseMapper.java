package suttonsLog.domain.mapper;

import domain.model.dbo.BlogEntryDbo;
import domain.model.response.BlogEntryResponse;
import suttonsLog.domain.model.BlogEntry;

/**
 * Created by leens on 8/11/2016.
 */
public class BlogEntryResponseMapper {
    public BlogEntry mapBlogEntryResponse(BlogEntryResponse blogEntryResponse){
        BlogEntry blogEntry = new BlogEntry();
        DateMapper dateMapper = new DateMapper();
        
        try{
            blogEntry.setId(blogEntryResponse.getBlogEntryDbo().getId());
            blogEntry.setTitle(blogEntryResponse.getBlogEntryDbo().getTitle());
            blogEntry.setBlogDate(dateMapper.mapBlogDate(blogEntryResponse.getBlogEntryDbo().getDatecreated()));
            blogEntry.setCategory(blogEntryResponse.getBlogEntryDbo().getCategory());
            blogEntry.setAuthor(blogEntryResponse.getBlogEntryDbo().getAuthor());
            blogEntry.setContents(blogEntryResponse.getBlogEntryDbo().getContents());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return blogEntry;
    }
}
