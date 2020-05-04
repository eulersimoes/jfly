package com.esg.jfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.jfly"})
@EntityScan(basePackages = { "com.jfly.domain.entity" })
public class JflyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JflyApplication.class, args);
	}

}
