package com.example.springcruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.springcruddemo.bean")
public class SpringCrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudDemoApplication.class, args);
    }

}
