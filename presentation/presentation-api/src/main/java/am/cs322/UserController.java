package am.cs322;

import am.cs322.model.CreateUserRequest;
import am.cs322.model.UserDTO;

public interface UserController {

     UserDTO createUser(CreateUserRequest request);

}
