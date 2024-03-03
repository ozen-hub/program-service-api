package com.devstack.lms.programserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEurkaClient
public class ProgramServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramServiceApiApplication.class, args);
	}

}
