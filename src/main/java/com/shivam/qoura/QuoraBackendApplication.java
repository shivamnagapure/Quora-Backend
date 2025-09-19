package com.shivam.qoura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@AutoConfigureAfter(FlywayAutoConfiguration.class)
public class QuoraBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoraBackendApplication.class, args);
	}

}
