package com.zo2ami;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.zo2ami")
@EntityScan("com.zo2ami")
@EnableJpaRepositories("com.zo2ami")
public class Zo2amiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zo2amiApplication.class, args);
	}

}
