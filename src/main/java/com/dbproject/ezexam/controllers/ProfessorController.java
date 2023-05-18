package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.configuration.Role;
import com.dbproject.ezexam.dto.AddProfessor;
import com.dbproject.ezexam.dto.AddUser;
import com.dbproject.ezexam.entities.Professor;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.services.ProfessorService;
import com.dbproject.ezexam.services.UserDetailsServiceImpl;
import com.dbproject.ezexam.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/professors")
public class ProfessorController {
    @Autowired
    private final ProfessorService professorService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping("/")
    public ResponseEntity<Object> getProfessors() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(professorService.getAllProfessors());
    }
    @PostMapping("/addProfessor")
    public ResponseEntity<HttpStatus> addProfessor(AddProfessor addProfessorDTO) {
        if(!userService.Register(
                new AddUser(addProfessorDTO.getUsername(), addProfessorDTO.getPassword(), Role.PROFESSOR)
        ))
            return ResponseEntity.badRequest().build();

        UserDetails addedUser = userDetailsService.loadUserByUsername(addProfessorDTO.getUsername());
        Professor professor = new Professor(addProfessorDTO.getName(), addProfessorDTO.getLastName(), (User) addedUser);
        return ResponseEntity
                .ok().build();
    }
}
