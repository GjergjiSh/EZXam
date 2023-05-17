package com.dbproject.ezexam.services;

import com.dbproject.ezexam.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
    @Autowired
    AuthenticationProvider authenticationProvider;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepo;

    // to implement these methods we first need DTO for professor and controller for it.
    // Then professor controller will use this service for auth/registr process
    public void Authenticate(){

    }
    public void Register(){

    }
}
