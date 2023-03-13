package com.example.test2.Repos;


import com.example.test2.Models.User;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {

    public EntityManager entityManager = null;


     @Query(value = "SELECT * FROM user  ORDER BY user_id ASC",nativeQuery = true)
     public List<User> getUsers();

    @Query(value = "DELETE FROM user WHERE user_id = :id", nativeQuery = true)
    public void deleteUser(@Param("id") long id);


}


// public List<User> rechercherUtilisateurs();






//public void supprimerUtilisateur(User user) ;


//public void supprimerUtilisateur(User user) {
//        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
//    }