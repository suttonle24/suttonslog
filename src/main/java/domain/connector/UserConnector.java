package domain.connector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.model.dbo.UserDbo;
import org.mongojack.JacksonDBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

@Component
public class UserConnector {
    private final MongoDbFactory mongo;
    private final String DATABASE = "local";
    private final String COLLECTION = "users";

    public UserConnector(){}

    @Autowired
    public UserConnector(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

    public UserDbo getUser(String username){
        try {
            DB db = mongo.getDb(DATABASE);
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
