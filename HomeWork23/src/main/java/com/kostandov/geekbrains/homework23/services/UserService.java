package com.kostandov.geekbrains.homework23.services;

import com.kostandov.geekbrains.homework23.entitys.User;
import com.kostandov.geekbrains.homework23.exceptions.ResourceNotFoundException;
import com.kostandov.geekbrains.homework23.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User getUser(Long userId){
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    public Iterable<User> requiredUsers(Long id){
        if(id==null){
            return getUsers();
        }else {
            return Collections.singletonList(getUser(id));
        }
    }
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }
}
