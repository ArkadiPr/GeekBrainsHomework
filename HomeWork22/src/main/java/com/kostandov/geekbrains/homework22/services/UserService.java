package com.kostandov.geekbrains.homework22.services;

import com.kostandov.geekbrains.homework22.entitys.User;
import com.kostandov.geekbrains.homework22.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    public List<User> requiredUsers(Long id){
        if(id==null){
            return getUsers();
        }else {
            User user=getUser(id);
            if(user==null){
                return getUsers();
            }
            return Collections.singletonList(user);
        }
    }
}