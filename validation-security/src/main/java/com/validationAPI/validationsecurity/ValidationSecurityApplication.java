package com.validationAPI.validationsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ValidationSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationSecurityApplication.class, args);
	}

}
