package com.shivam.qoura.service;

import com.shivam.qoura.adapters.UserRequestToUser;
import com.shivam.qoura.models.User;
import com.shivam.qoura.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository ;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository ;
    }

    public User save(User user){
        System.out.println(user.getEmail());
        return userRepository.save(user);
    }

    public User findUserById(Long Id){
        Optional<User> user = userRepository.findById(Id);
        /*  if(user.isEmpty()){
            return null ;
        }
        return user.get() ;*/
        return user.orElse(null);
    }

    public User updateUserById(Long Id , User user){
        Optional<User> existingUser = userRepository.findById(Id) ;

        existingUser.get().setUserName(user.getUserName());
        existingUser.get().setBio(user.getBio());
        existingUser.get().setEmail(user.getEmail());

        return userRepository.save(existingUser.get());
    }

}
