package com.dbproject.ezexam.controllers;

import com.dbproject.ezexam.services.StudentService;
import com.dbproject.ezexam.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<Object> getStudents() {
        return ResponseUtils.returnSuccess(
                studentService.getAllStudents()
        );
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable Long id) {
        try {
            return ResponseUtils.returnSuccess(studentService.getStudentById(id));
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }

    }

    @GetMapping("/matnr/{matnr}")
    public ResponseEntity<Object> getStudentByMatnr(@PathVariable String matnr) {
        try {
            return ResponseUtils.returnSuccess(studentService.getStudentByMatnr(matnr));
        } catch (NoSuchElementException e) {
            return ResponseUtils.returnNotFound(e.getMessage());
        }
    }

    @GetMapping("/fullname")
    public ResponseEntity<Object> getStudentByFullName(@RequestParam("name") String name,
                                                       @RequestParam("lastname") String lastname) {
        return ResponseUtils.returnSuccess(
                studentService.getStudentsByFullName(name, lastname)
        );
    }
}
