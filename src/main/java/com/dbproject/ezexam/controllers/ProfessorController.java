package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.services.ProfessorService;
import com.dbproject.ezexam.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/professors")
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping("/")
    public ResponseEntity<Object> getProfessors() {
        return ResponseUtils.returnSuccess(
                professorService.getAllProfessors()
        );
    }

    @GetMapping("/{id}")
    // TODO add error handling
    public ResponseEntity<Object> getProfessorById(@PathVariable Long id) {
        return ResponseUtils.returnSuccess(
                professorService.getProfessorById(id)
        );
    }
}
