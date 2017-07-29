package suttonsLog.domain.mapper;

import domain.model.dbo.BlogEntryDbo;
import suttonsLog.domain.model.BlogEntry;

import java.util.Date;

public class BlogMapper {
    public BlogEntryDbo blogEntryToDbo(BlogEntry blogEntry){
        BlogEntryDbo blogEntryDbo = new BlogEntryDbo();
        DateMapper dateMapper = new DateMapper();

        blogEntryDbo.setTitle(blogEntry.getTitle());
        blogEntryDbo.setDatecreated(new Date());
        blogEntryDbo.setCategory(blogEntry.getCategory());
        blogEntryDbo.setAuthor(blogEntry.getAuthor());
        blogEntryDbo.setContents(blogEntry.getContents());

        return blogEntryDbo;
    }
}
