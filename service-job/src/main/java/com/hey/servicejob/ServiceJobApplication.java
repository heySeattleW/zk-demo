package com.hey.servicejob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceJobApplication.class, args);
    }

}
