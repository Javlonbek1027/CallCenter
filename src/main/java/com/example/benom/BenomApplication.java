package com.example.benom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BenomApplication {
    public static void main(String[] args) {
        SpringApplication.run(BenomApplication.class, args);
    }

}
