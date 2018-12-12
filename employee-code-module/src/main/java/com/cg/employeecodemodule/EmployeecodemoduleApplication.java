package com.cg.employeecodemodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
@EnableEurekaClient
public class EmployeecodemoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeecodemoduleApplication.class, args);
	}
}
