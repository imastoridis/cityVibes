package com.cityVibes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cityVibes")
@EnableJpaRepositories(basePackages = "com.cityVibes") // Explicitly claim these for JPA
@EntityScan(basePackages = "com.cityVibes")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
