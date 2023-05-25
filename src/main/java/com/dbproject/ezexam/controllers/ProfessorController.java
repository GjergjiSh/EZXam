package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Professor;
import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.services.ProfessorService;
import com.dbproject.ezexam.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/professors")
public class ProfessorController {
    private final ProfessorService professorService;


    @GetMapping("/")
    public ResponseEntity<Object> getProfessors() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(professorService.getAllProfessors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfessorById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(professorService.getProfessorById(id));
    }
}
