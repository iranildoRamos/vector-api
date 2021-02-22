package com.example.vector.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.vector.api.config.property.VectorApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(VectorApiProperty.class)
public class VectorApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(VectorApplication.class, args);
	}

}
