package com.example.zuulserver;

import com.example.zuulserver.filter.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
@EnableZuulProxy
//@EnableOAuth2Sso
public class ZuulServerApplication {

    //以下@Bean為filter部分
    @Bean
    public FirstPreFilter firstPreFilter(){
        return new FirstPreFilter();
    }
    @Bean
    public SecondPreFilter secondPreFilter(){
        return new SecondPreFilter();
    }
    @Bean
    public ThirdPreFilter thirdPreFilter(){
        return new ThirdPreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

}
