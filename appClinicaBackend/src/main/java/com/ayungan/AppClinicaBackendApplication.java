package com.ayungan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class AppClinicaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppClinicaBackendApplication.class, args);
		  System.out.println("version: " + SpringVersion.getVersion());
	}
}
