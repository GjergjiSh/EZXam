package com.dbproject.ezexam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @GetMapping("/students/{id}")
    @ResponseBody
    public String getStudent(Long id) {
        return "This rest call needs to be set";
    }

}
