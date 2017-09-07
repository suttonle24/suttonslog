package domain.connector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.model.dbo.BlogEntryDbo;
import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leens on 8/10/2016.
 */
public class BlogEntryConnector {
    private final String IP = "192.168.1.199";
    private final int PORT = 27017;
    private final String DATABASE = "local";
    private final String COLLECTION = "blogs";

    public BlogEntryDbo getLatestBlogEntry(){
        BlogEntryDbo latestBlog = null;

        try {
            MongoClient mongoClient = new MongoClient(IP, PORT);
            DB db = mongoClient.getDB(DATABASE);
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
            MongoClient mongoClient = new MongoClient(IP, PORT);
            DB db = mongoClient.getDB(DATABASE);
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
            MongoClient mongoClient = new MongoClient(IP, PORT);
            DB db = mongoClient.getDB(DATABASE);
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
