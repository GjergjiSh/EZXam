package com.dbproject.ezexam;

import com.dbproject.ezexam.config.Role;
import com.dbproject.ezexam.dto.AddUser;
import com.dbproject.ezexam.entities.User;
import com.dbproject.ezexam.repositories.UserRepo;
import com.dbproject.ezexam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@SpringBootConfiguration
public class EzexamApplication{

	public static void main(String[] args) {
		SpringApplication.run(EzexamApplication.class, args);
	}

}
