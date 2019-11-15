package com.example.clientb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientCApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientCApplication.class, args);
    }

}
