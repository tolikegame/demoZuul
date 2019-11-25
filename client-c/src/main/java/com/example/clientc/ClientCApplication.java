package com.example.clientc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
public class ClientCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientCApplication.class, args);
    }

}
