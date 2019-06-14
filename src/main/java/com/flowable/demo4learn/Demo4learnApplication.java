package com.flowable.demo4learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.flowable.demo4learn.*")
public class Demo4learnApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo4learnApplication.class, args);
	}

}
