package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.entities.Student;
import com.dbproject.ezexam.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<Object> getStudents() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentService.getAllStudents());
    }

    @GetMapping("/id/{id}")
    @ResponseBody
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentService.getStudentById(id));
    }

    @GetMapping("/fullname")
    @ResponseBody
    public ResponseEntity<Object> getStudentByFullName(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname) {
        List<Student> students = studentService.getStudentsByFullName(name, lastname);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(students);
    }
}
