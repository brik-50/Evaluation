package com.example.test2.Repos;


import com.example.test2.Models.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public EntityManager entityManager = null;


     @Query(value = "SELECT * FROM user  ORDER BY user_id ASC",nativeQuery = true)
     public List<User> getUsers();

    @Query(value = "DELETE FROM user WHERE user_id = IFNULL(:id, 0)", nativeQuery = true)
    public void deleteUser(@Param("id") Long id);




}


