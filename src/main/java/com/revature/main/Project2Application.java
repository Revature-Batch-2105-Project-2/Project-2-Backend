package com.revature.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan("com.revature")
@EnableJpaRepositories("com.revature.repo")
@EntityScan("com.revature.beans")
@Configuration
public class Project2Application extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Project2Application.class);
	}
	
	// TODO: this doesn't work in its current configuration, should it be changed or remov ed?
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("http://localhost:8080/", "http://localhost:4200/", "http://ec2-54-183-249-67.us-west-1.compute.amazonaws.com:8080/", "http://revature-bucket.s3-website-us-west-1.amazonaws.com/");
			}
		};
	}
}
