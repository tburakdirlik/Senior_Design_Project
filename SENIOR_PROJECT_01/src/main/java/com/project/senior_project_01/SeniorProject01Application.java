package com.project.senior_project_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeniorProject01Application {
    public static void main(String[] args) {
        SpringApplication.run(SeniorProject01Application.class, args);
        //db tun ->  docker-compose -f .\docker-compose.yml up -d
    }
}
