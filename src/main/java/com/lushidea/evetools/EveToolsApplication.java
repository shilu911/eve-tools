package com.lushidea.evetools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EveToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EveToolsApplication.class, args);
	}

}
