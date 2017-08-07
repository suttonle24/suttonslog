package domain.connector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.mapper.BlogEntryResponseMapper;
import domain.model.dbo.BlogEntryDbo;
import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leens on 8/10/2016.
 */
@Component
public class BlogEntryConnector {

    private final MongoDbFactory mongo;
    private final String DATABASE = "local";
    private final String COLLECTION = "blogs";

    @Autowired
    public BlogEntryConnector(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

    BlogEntryResponseMapper blogEntryResponseMapper = new BlogEntryResponseMapper();

    public BlogEntryDbo getLatestBlogEntry(){
        BlogEntryDbo latestBlog = null;

        try {
            DB db = mongo.getDb(DATABASE);
            DBCollection collection = db.getCollection(COLLECTION);
            JacksonDBCollection<BlogEntryDbo, String> blogs = JacksonDBCollection.wrap(collection, BlogEntryDbo.class, String.class);


            BasicDBObject query = new BasicDBObject("id",-1);

            DBCursor<BlogEntryDbo> result = blogs.find().sort(query).limit(1);

            if(result.hasNext()){
                latestBlog = result.next();
            }
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }

        return latestBlog;
    }

    public List<BlogEntryDbo> getAllBlogEntries(){
        List<BlogEntryDbo> blogEntries = new LinkedList<>();

        try {
            DB db = mongo.getDb(DATABASE);
            DBCollection collection = db.getCollection(COLLECTION);
            JacksonDBCollection<BlogEntryDbo, String> blogs = JacksonDBCollection.wrap(collection, BlogEntryDbo.class, String.class);


            BasicDBObject query = new BasicDBObject("id",-1);

            DBCursor<BlogEntryDbo> result = blogs.find().sort(query);

            while(result.hasNext()){
                try {
                    blogEntries.add(result.next());
                }
                catch(Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        catch (Exception e){
            System.out.print(e.getMessage());
        }

        return blogEntries;
    }

    public boolean createBlogEntry(BlogEntryDbo blogEntryDbo){
        try {
            DB db = mongo.getDb(DATABASE);
            DBCollection collection = db.getCollection(COLLECTION);
            JacksonDBCollection<BlogEntryDbo, String> blogs = JacksonDBCollection.wrap(collection, BlogEntryDbo.class, String.class);

            BasicDBObject query = new BasicDBObject();

            WriteResult result = blogs.insert(blogEntryDbo);

            if(result.getSavedObject() != null){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

}
