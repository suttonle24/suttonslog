package domain.connector;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import domain.model.dbo.ProjectDbo;
import org.mongojack.DBCursor;
import org.mongojack.JacksonDBCollection;
import org.springframework.util.Assert;

import java.util.List;

public class ProjectConnector {
    private final String IP = "192.168.1.199";
    private final int PORT = 27017;
    private final String DATABASE = "local";
    private final String COLLECTION = "portfolio_content";

    public ProjectDbo getProject(int sortOrder){
        ProjectDbo projectDbo = null;

        try {
            MongoClient mongoClient = new MongoClient(IP, PORT);
            DB db = mongoClient.getDB(DATABASE);
            DBCollection collection = db.getCollection(COLLECTION);
            JacksonDBCollection<ProjectDbo, String> projects = JacksonDBCollection.wrap(collection, ProjectDbo.class, String.class);


            BasicDBObject query = new BasicDBObject("sort_order", sortOrder);

            DBCursor<ProjectDbo> result = projects.find().sort(query).limit(1);

            if(result.hasNext()){
                projectDbo = result.next();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return projectDbo;
    }

    public List<ProjectDbo> getProjects(){
        List<ProjectDbo> projectDbos = null;

        try {
            MongoClient mongoClient = new MongoClient(IP, PORT);
            DB db = mongoClient.getDB(DATABASE);
            DBCollection collection = db.getCollection(COLLECTION);
            JacksonDBCollection<ProjectDbo, String> projects = JacksonDBCollection.wrap(collection, ProjectDbo.class, String.class);


            BasicDBObject query = new BasicDBObject("id", -1);

            DBCursor<ProjectDbo> result = projects.find().sort(query).limit(1);

            while(result.hasNext()){
                try {
                    projectDbos.add(result.next());
                }
                catch(Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return projectDbos;
    }
}
