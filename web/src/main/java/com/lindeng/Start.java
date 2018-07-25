package com.lindeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScan(basePackages = "com.lindeng.*")
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}
