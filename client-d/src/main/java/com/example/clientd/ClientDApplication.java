package com.example.clientd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
public class ClientDApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientDApplication.class, args);
    }

}
