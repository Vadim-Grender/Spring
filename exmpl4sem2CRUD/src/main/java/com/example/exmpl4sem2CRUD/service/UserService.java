package com.example.exmpl4sem2CRUD.service;

import com.example.exmpl4sem2CRUD.model.User;
import com.example.exmpl4sem2CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(int id) { userRepository.deleteById(id);}

    public User getOne(int id) {
        return userRepository.getOne(id);
    }

    public User updateUser(User updatedUser) {
        return userRepository.update(updatedUser);
    }

}
