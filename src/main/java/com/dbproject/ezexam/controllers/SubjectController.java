package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Subject;
import com.dbproject.ezexam.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<Subject>> getSubjects() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(subjectService.getAllSubjects());
    }

    @GetMapping("/subject/{name}")
    public ResponseEntity<Optional<Subject>> getSubjectByName(@PathVariable String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(subjectService.getSubjectByName(name));
    }
}
