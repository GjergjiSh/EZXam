package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.configuration.Role;
import com.dbproject.ezexam.dto.AddProfessor;
import com.dbproject.ezexam.dto.AddUser;
import com.dbproject.ezexam.dto.AuthUser;
import com.dbproject.ezexam.entities.Professor;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/authUser")
    public ResponseEntity<HttpStatus> authUser(AuthUser authUser) {
        if(!userService.Authenticate(authUser.getUsername(), authUser.getPassword()))
            return ResponseEntity.badRequest().build();
        return ResponseEntity
                .ok().build();
    }
}
