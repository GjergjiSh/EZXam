package com.dbproject.ezexam.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewsController {
    @RequestMapping({"/login-registration-view", "/"})
    public String userRegistrationView() {
        return "login_registr";
    }

    @RequestMapping("/edit-subject-view")
    public String editSubjectView(@RequestParam("subjectName") String subjectName, Model model) {
        model.addAttribute("subjectName", subjectName);
        return "edit-subject";
    }

}