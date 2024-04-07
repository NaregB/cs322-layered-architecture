package am.homework;

import am.homework.model.UserDTO;

public interface UserService {

    public UserDTO createUser(String firstName, String lastName);

}