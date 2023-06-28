package com.travelatlasmorocco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class TravelatlasmoroccoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TravelatlasmoroccoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(TravelatlasmoroccoApplication.class, args);
	}
	// entry point
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}
	//entry point we should declare out context

	@Bean
	public SpringApplicationContext springApplicationContext () {
		return new SpringApplicationContext();
	}
}
