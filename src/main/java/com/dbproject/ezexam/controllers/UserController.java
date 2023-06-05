package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.dtos.AuthUser;
import com.dbproject.ezexam.dtos.GetAuthedProfessor;
import com.dbproject.ezexam.entities.Professor;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.repositories.ProfessorRepo;
import com.dbproject.ezexam.services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    private final UserDetailsService userDetailsService;

    @Autowired
    private final ProfessorRepo professorRepo;

    @PutMapping("/authUser")
    public ResponseEntity<GetAuthedProfessor> authUser(@RequestBody AuthUser authUser, HttpSession httpSession) {
        if(!userService.Authenticate(authUser.getUsername(), authUser.getPassword(), httpSession))
            return ResponseEntity.badRequest().build();

        User user = (User) userDetailsService.loadUserByUsername(authUser.getUsername());
        Professor professor = professorRepo.findByUserId(user.getId());
        GetAuthedProfessor getAuthedUser = new GetAuthedProfessor(
                professor.getId().toString(),
                professor.getName(),
                professor.getLastname()
                );
        return ResponseEntity.ok(getAuthedUser);
    }
}
