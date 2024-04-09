package am.cs322;

import am.cs322.model.UserDTO;

public interface UserService {

    UserDTO createNewUser(String firstName, String lastName);

}
