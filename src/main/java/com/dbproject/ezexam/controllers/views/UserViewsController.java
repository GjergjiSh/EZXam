package com.dbproject.ezexam.controllers.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class UserViewsController {
    @RequestMapping({"/login-registration-view", "/"})
    public String userRegistrationView() {
        return "login_registr";
    }

}
