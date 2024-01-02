package org.example.restdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.example.restdatajpa.controller"
        ,"org.example.restdatajpa.services"
        ,"org.example.restdatajpa.config"})
public class RestDataJpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestDataJpaApplication.class, args);
    }
}
