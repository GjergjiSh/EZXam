package com.dbproject.ezexam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@SpringBootConfiguration
public class EzexamApplication{

	public static void main(String[] args) {
		SpringApplication.run(EzexamApplication.class, args);
	}

}
