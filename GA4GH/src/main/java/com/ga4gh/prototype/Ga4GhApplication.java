package com.ga4gh.prototype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class Ga4GhApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ga4GhApplication.class, args);
	}

}
