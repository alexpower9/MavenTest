package com.example.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"student","testpage"})
@EntityScan("student")
@EnableJpaRepositories(basePackages = "student")
public class MyAppApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(MyAppApplication.class, args);
	}
	

}
