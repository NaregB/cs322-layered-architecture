package am.homework;

import am.homework.model.CreateUserRequest;
import am.homework.model.UserDTO;

public interface UserController {

    public UserDTO createUser(CreateUserRequest request);

}
