package domain.connector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.model.dbo.UserDbo;
import org.mongojack.JacksonDBCollection;

public class UserConnector {
    private final String IP = "192.168.1.199";
    private final int PORT = 27017;
    private final String DATABASE = "local";
    private final String COLLECTION = "users";

    public UserDbo getUser(String username){
        try {

            MongoClient mongoClient = new MongoClient(IP, PORT);
            DB db = mongoClient.getDB(DATABASE);
            DBCollection collection = db.getCollection(COLLECTION);
            JacksonDBCollection<UserDbo, String> users = JacksonDBCollection.wrap(collection, UserDbo.class, String.class);

            BasicDBObject query = new BasicDBObject();

            return users.findOne(query);
        }
        catch(Exception e){
            return new UserDbo();
        }
    }
}
