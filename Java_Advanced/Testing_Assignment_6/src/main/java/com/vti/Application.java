package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
//	public WebMvcConfigurer configurer() {
//		return new WebMvcConfigurer() {
//			public void addCorsMappings ( CorsRegistry registry) {
//				registry.addMapping("/*").allowedOrigins("http://localhost:5500");
//			}
//		};
//	}
}
