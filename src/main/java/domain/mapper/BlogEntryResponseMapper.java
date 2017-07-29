package domain.mapper;

import domain.model.dbo.BlogEntryDbo;
import domain.model.valueObject.Category;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;

/**
 * Created by leens on 8/10/2016.
 */
@Component
public class BlogEntryResponseMapper {
    public BlogEntryDbo mapBlogEntryResponse(ResultSet queryResult){
        BlogEntryDbo blogEntryDbo = new BlogEntryDbo();

        try {
            blogEntryDbo.setTitle(queryResult.getString("title"));
            blogEntryDbo.setDatecreated(queryResult.getTimestamp("dateCreated"));
            blogEntryDbo.setCategory(Category.valueOf(queryResult.getString("category")));
            blogEntryDbo.setAuthor(queryResult.getString("author"));
            blogEntryDbo.setContents(queryResult.getString("contents"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return blogEntryDbo;
    }
}
