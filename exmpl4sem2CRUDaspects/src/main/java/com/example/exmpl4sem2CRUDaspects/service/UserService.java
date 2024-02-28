package com.example.exmpl4sem2CRUDaspects.service;

import com.example.exmpl4sem2CRUDaspects.aspects.TrackUserAction;
import com.example.exmpl4sem2CRUDaspects.model.User;
import com.example.exmpl4sem2CRUDaspects.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @TrackUserAction
    public List<User> findAll(){
        return userRepository.findAll();
    }
    @TrackUserAction
    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(int id) { userRepository.deleteById(id);}
    @TrackUserAction
    public User getOne(int id) {
        return userRepository.getOne(id);
    }
    @TrackUserAction
    public User updateUser(User updatedUser) {
        return userRepository.update(updatedUser);
    }

}
