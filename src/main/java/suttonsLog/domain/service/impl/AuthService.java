package suttonsLog.domain.service.impl;

import com.mongodb.*;
import domain.model.dbo.UserDbo;
import org.mongojack.JacksonDBCollection;
import suttonsLog.domain.mapper.AuthMapper;
import suttonsLog.domain.model.AuthInfo;
import suttonsLog.domain.service.IAuthService;

/**
 * Created by leens on 3/3/2017.
 */
public class AuthService implements IAuthService {
    public AuthInfo getAuthentication(String username, String password){
        AuthMapper authMapper = new AuthMapper();

        try {
            MongoClient mongoClient = new MongoClient("192.168.1.199", 32768);
            DB db = mongoClient.getDB("local");
            DBCollection collection = db.getCollection("users");
            JacksonDBCollection<UserDbo, String> users = JacksonDBCollection.wrap(collection, UserDbo.class, String.class);

            BasicDBObject query = new BasicDBObject();
            query.put("username", username);

            UserDbo user = users.findOne(query);

            if(user != null) {
                if(user.getPassword().equals(password)){
                    System.out.print("Yay!");
                    return authMapper.MapAuthResponse(user);
                }
                else {
                    System.out.print("Boo!");
                    return authMapper.MapAuthResponse(new UserDbo());
                }
            }
            else {
                return authMapper.MapAuthResponse(new UserDbo());
            }
        }
        catch (Exception e) {
            return authMapper.MapAuthResponse(new UserDbo());
        }
    }
}
