package am.cs322.model;

import java.util.Objects;


public class UserDTO {


    private String fullName;


   public UserDTO(String fullName){
       this.fullName = fullName;
   }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(fullName, userDTO.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

}
