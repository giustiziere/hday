package ru.kvashin.hday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class HdayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HdayApplication.class, args);
	}

}
