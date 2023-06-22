package alz.genfive.webshop.dataTransferObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Getter
public class UserLoginDTO {

    private String email;
    private String password;

    /**
     * AllArgsCOnstructor looks like that:
     */
     public UserLoginDTO(String email, String password){
         this.email = email;
         this.password = password;
     }
}
