package org.example.uberprojectauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@EnableJpaAuditing
@EntityScan("org.example.uberprojectentityservice.Models ")

public class UberProjectAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UberProjectAuthServiceApplication.class, args);
    }

}
