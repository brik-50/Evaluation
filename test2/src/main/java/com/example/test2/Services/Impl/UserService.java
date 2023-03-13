package com.example.test2.Services.Impl;

import com.example.test2.Exceptions.UserNotFoundException;
import com.example.test2.Models.Projet;
import com.example.test2.Models.User;
import com.example.test2.Repos.UserRepo;
import com.example.test2.Services.InterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.test2.Repos.UserRepo.entityManager;

@Service
public class UserService implements InterUserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserById(long id) throws UserNotFoundException {
        Optional<User> user= userRepo.findById(id);
        if(user.isPresent()){
            return user.get();
        }else{
            throw new UserNotFoundException("user not found with id ="+id);
        }
    }



    @Override
    public void deleteUser(long id) {
         userRepo.deleteUser(id);

    }

    @Override
    public List<User> getUsers() {
        return userRepo.getUsers();
    }



}
