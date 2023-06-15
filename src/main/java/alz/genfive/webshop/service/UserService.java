package alz.genfive.webshop.service;

import alz.genfive.webshop.entity.User;
import alz.genfive.webshop.exception.UserNotFoundException;
import alz.genfive.webshop.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    // We bring in the JPA-repository ( / CRUD-Repo). So that we can inject it in this class
    private final UserRepo userRepo;

    // = wenn über Klasse stehen würde "@RequiredArgsConstructor"
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    //Create User in the database:
    public User createUser(User user){
        return this.userRepo.save(user);
    }

    // Gives you a list of all Users: (the Crud-Repo does this for us with its method.)
    public List<User> findAllUsers(){
        return this.userRepo.findAll();
    }

    // Gives you only one User, searched by id:
    public User findUserById(Long id){
        return this.userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("FIND USER ERROR: User with the ID " + id + " was not found."));
        /* "findUserById()"-method is a "query-method".
        It does not exist by default, we wrote it in the UserRepo-interface, but because of the naming convention,
        Spring is able to understand what to do, it makes:
        SELECT (because of the "find")
        * (all entries from the table)
        FROM webshop_user table (because of the "User" in the Method name)
        WHERE ID=id (because of the "ById" and the parameter)
         */
        /*
        The .orElseThrow is necessary because the return type of our method is "Optional" and not "User",
        so we need to handle this exception where we don't get the User.
         */
    }

    //Update Users:
    public User updateUser(User user){
        User updatedUser = userRepo.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("UPDATE ERROR: User with the ID " + user.getId() + " was not found."));
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setShoppingCart(user.getShoppingCart());
        return this.userRepo.save(updatedUser);
    }

    //Delete User by Id:
    public void deleteUser(Long id){
        this.userRepo.deleteById(id);
    }
}
