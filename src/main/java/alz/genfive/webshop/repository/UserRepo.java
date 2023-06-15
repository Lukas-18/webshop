package alz.genfive.webshop.repository;

import alz.genfive.webshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// CrudRepository parameters: 1. What class this repo is for  &  2. Which type the primary key in this class have
// JpaRepo extends "ListCrudRepository" which in turn uses CrudRepository, so you have all the functions of CRUD-Repo in JPA-Repo.
// (Strg+Mausklick auf JpaRepository springt in das Interface.)
public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    //The return type is "Optional" and not "User"(like it was at first), because there could be a situation where the id does not exist
}
