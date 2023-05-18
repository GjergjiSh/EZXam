package com.dbproject.ezexam.services;

import com.dbproject.ezexam.dto.AddUser;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationProvider authenticationProvider;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepo;


    public boolean Authenticate(String username, String password) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication result = authenticationProvider.authenticate(authentication);
            return result.isAuthenticated();
        } catch (AuthenticationException ex) {
            return false;
        }
    }
    public boolean Register(AddUser addUser){
        if(userRepo.findByUsername(addUser.getUsername()).isPresent())
            return false;
        String encryptedPassword = passwordEncoder.encode(addUser.getPassword());
        User user = new User(addUser.getUsername(), encryptedPassword, addUser.getRole());
        userRepo.save(user);
        return true;
    }
}
