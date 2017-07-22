package suttonsLog.domain.mapper;

import domain.model.dbo.BlogEntryDbo;
import domain.model.response.BlogEntryResponse;
import suttonsLog.domain.model.BlogEntry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
            //blogEntry.setBlogDate(dateMapper.mapBlogDate(blogEntryResponse.getBlogEntryDbo().getDatecreated()));
            //blogEntry.setCategory(blogEntryResponse.getBlogEntryDbo().getCategory());
            blogEntry.setAuthor(blogEntryResponse.getBlogEntryDbo().getAuthor());
            blogEntry.setContents(blogEntryResponse.getBlogEntryDbo().getContents());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return blogEntry;
    }

    public List<BlogEntry> mapBlogEntryListResponse(BlogEntryResponse blogEntryResponse){
        List<BlogEntry> blogEntries = new ArrayList<BlogEntry>();
        DateMapper dateMapper = new DateMapper();

        try{
            List<BlogEntryDbo> blogEntryDbos = blogEntryResponse.getBlogEntries();

            for(Iterator<BlogEntryDbo> i = blogEntryDbos.iterator(); i.hasNext();){
                BlogEntryDbo blogEntryDbo = i.next();
                BlogEntry blogEntry = new BlogEntry();

                blogEntry.setId(blogEntryDbo.getId());
                blogEntry.setTitle(blogEntryDbo.getTitle());
                //blogEntry.setBlogDate(dateMapper.mapBlogDate(blogEntryDbo.getDatecreated()));
                //blogEntry.setCategory(blogEntryDbo.getCategory());
                blogEntry.setAuthor(blogEntryDbo.getAuthor());
                blogEntry.setContents(blogEntryDbo.getContents());

                blogEntries.add(blogEntry);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return blogEntries;
    }
}
