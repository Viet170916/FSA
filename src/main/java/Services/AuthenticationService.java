package Services;

import Data.DBEntity;
import Models.Entities.User;

public class AuthenticationService{
  public static User getAuthentication(String email, String password) throws Exception{
    User user = new User();
    user.setEmail(email);
    user.setPassword(password);
    user = new DBEntity<>(User.class)
            .getObjectsWithConditions(user)
            .get(0);
    user.setPassword(null);
    return user;
  }
}
