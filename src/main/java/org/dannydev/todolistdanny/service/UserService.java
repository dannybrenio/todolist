package org.dannydev.todolistdanny.service;

import org.dannydev.todolistdanny.model.User;
import org.dannydev.todolistdanny.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public boolean register(User user){

        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            return false;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        //System.out.println(user.getPassword());
        userRepository.save(user);
        return true;
    }
}
