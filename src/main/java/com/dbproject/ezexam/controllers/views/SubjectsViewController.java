package com.dbproject.ezexam.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SubjectsViewController {

    @RequestMapping("/subjects-view")
    public String subjectsView() {
        return "subjects";
    }
}
