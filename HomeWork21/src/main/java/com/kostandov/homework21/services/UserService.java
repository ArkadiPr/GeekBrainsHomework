package com.kostandov.homework21.services;

import com.kostandov.homework21.entitys.User;
import com.kostandov.homework21.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long userId){
        return userRepository.loadById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
