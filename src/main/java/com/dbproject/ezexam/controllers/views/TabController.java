package com.dbproject.ezexam.controllers.views;

import com.dbproject.ezexam.controllers.SubjectController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TabController {

    @Autowired
    SubjectController subjectController;

    @RequestMapping("/subjects-view")
    public String subjectsView(Model model) {
        model.addAttribute("activeTab", "subjects");
        return "subjects";
    }

    @RequestMapping("/sessions-view")
    public String sessionsView(Model model) {
        model.addAttribute("activeTab", "sessions");
        return "sessions/sessions";
    }

}
