package com.devstack.lms.programserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProgramServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramServiceApiApplication.class, args);
	}

}
