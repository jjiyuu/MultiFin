package com.multi.multifin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MultiFin0205Application {

	public static void main(String[] args) {
		SpringApplication.run(MultiFin0205Application.class, args);
	}

}
