package suttonsLog.domain.mapper;

import domain.model.dbo.UserDbo;
import suttonsLog.domain.model.FullName;
import suttonsLog.domain.model.User;

public class UserMapper {
    public User mapUser(UserDbo userDbo){
        User user = new User();
        FullName fullName = new FullName();

        user.setEmail(userDbo.getEmail());
        fullName.setFirstName(userDbo.getName().getFirstName());
        fullName.setLastName(userDbo.getName().getLastName());
        user.setName(fullName);
        user.setPassword(userDbo.getPassword());
        user.setUsername(userDbo.getUsername());

        return user;
    }
}
