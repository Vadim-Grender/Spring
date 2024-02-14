package com.example.HomeWorkFour.services;

import com.example.HomeWorkFour.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    public List<User> getAllUsers(){
        return users;
    }

}
