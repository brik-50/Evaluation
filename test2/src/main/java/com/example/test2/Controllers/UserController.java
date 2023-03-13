package com.example.test2.Controllers;

import com.example.test2.Exceptions.UserNotFoundException;
import com.example.test2.Models.User;
import com.example.test2.Services.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }

    @GetMapping("User")
        public List<User> getUser(){
          return userService.getUsers();
        }


    @PostMapping("delete/user/{id}")
    public void deleteUser(long id) throws UserNotFoundException {
        userService.deleteUser(id);
    }


}
