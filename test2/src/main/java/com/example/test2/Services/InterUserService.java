package com.example.test2.Services;


import com.example.test2.Exceptions.UserNotFoundException;
import com.example.test2.Models.User;

import java.util.List;

public interface InterUserService {

    public User getUserById(long id) throws UserNotFoundException;

    public void deleteUser(long id);


    public List<User> getUsers();


}


