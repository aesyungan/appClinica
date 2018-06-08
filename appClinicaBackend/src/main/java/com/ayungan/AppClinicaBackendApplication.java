package com.ayungan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class AppClinicaBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppClinicaBackendApplication.class, args);
		System.out.println("version: " + SpringVersion.getVersion());
	}

	// para generar war para tomcat
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(AppClinicaBackendApplication.class);
	}
/*
	@Autowired
	private OAuth2ClientContext context;
	
	@GetMapping("/access_token")
	public String getToken() {
		String token = context.getAccessToken().getValue();
		System.out.println("Token: " + token);
		return token;
	}
	
	@GetMapping("/user")
	public Principal getUser(Principal user) {
		return user;
	}
*/
}
