package com.dbproject.ezexam;

import com.dbproject.ezexam.config.Role;
import com.dbproject.ezexam.dto.AddUser;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.repositories.UserRepo;
import com.dbproject.ezexam.services.UserService;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DataInitializer implements ApplicationRunner {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var user1 = userRepo.findByUsername("test1").get();
        if (user1 != null) {
            String encryptedPassword1 = passwordEncoder.encode(user1.getPassword());
            user1.setPassword(encryptedPassword1);
            userRepo.save(user1);
        }
        var user2 = userRepo.findByUsername("test2").get();
        if (user2 != null) {
            String encryptedPassword2 = passwordEncoder.encode(user2.getPassword());
            user2.setPassword(encryptedPassword2);
            userRepo.save(user2);
        }
    }

}
