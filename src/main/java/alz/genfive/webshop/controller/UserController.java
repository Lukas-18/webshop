package alz.genfive.webshop.controller;

import alz.genfive.webshop.dataTransferObject.UserLoginDTO;
import alz.genfive.webshop.entity.User;
import alz.genfive.webshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webshop_user") // Default URL to access the UserController / this class.
//@CrossOrigin(origins = "http://localhost:4200") // To communicate with frontend, but done this in WebshopApplication.java
public class UserController {

    // Bring in the service, because we are going to use it in this class:
    private final UserService userService;

    //Inject the service into the constructor, so that we can Autowire the Service inside of that class:

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    // Method that can return all of the users that we have in the application:
    // So this is gonna return an HTTP-Response and in the body of that HTTP-Response there's gonna be a list or an array of Users.
    // We wanna the method to return an HTTP_Response, that's why it have the type "ResponseEntity".
    @GetMapping("/all") // This is the path or better said the URL, whenever the client go to "/user/all" its gone fire up this method.
                          // ("/user" is defined at the class as the default URL, and the "/all" is going to be appended (angehängt).)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}") // The "Pathvariable"-annotation gets the id coming from the path (so this "{id}" in the url.
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    // This method expect as the parameter the whole User-Object which is gonna be in JSON-Format.
    /* To get that information we use the annotation "@RequestBody" and then we are converting whatever comes in as an User,
        because we know that's what it's going to be. */
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        // The status code "CREATED" means we created something on the server and that's what we're actually doing by creating a new User.
    }

    //FOR LOGIN:
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO userLoginDTO){
        User user = userService.findUserByEmail(userLoginDTO.getEmail());
        System.out.println("FOLGENDER USER GEFUNDEN: " + user);
        if (user.getPassword().equals(userLoginDTO.getPassword())){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

    @PutMapping("/update")
    // PUT because Update
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    // PUT because Update
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
