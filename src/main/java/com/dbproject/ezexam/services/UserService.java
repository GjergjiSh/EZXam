package com.dbproject.ezexam.services;

import com.dbproject.ezexam.dtos.AddUser;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.repositories.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.security.web.context.HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY;

@Service
public class UserService {
    @Autowired
    AuthenticationProvider authenticationProvider;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepo;


    public boolean Authenticate(String username, String password, HttpSession httpSession) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication result = authenticationProvider.authenticate(authentication);
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(result);
            httpSession.setAttribute(SPRING_SECURITY_CONTEXT_KEY, sc);
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
