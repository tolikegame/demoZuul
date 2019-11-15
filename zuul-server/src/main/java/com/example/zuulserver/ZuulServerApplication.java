package com.example.zuulserver;

import com.example.zuulserver.filter.FirstPreFilter;
import com.example.zuulserver.filter.PostFilter;
import com.example.zuulserver.filter.SecondPreFilter;
import com.example.zuulserver.filter.ThirdPreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
public class ZuulServerApplication extends WebSecurityConfigurerAdapter {

    //以下@Bean為filter部分
//    @Bean
//    public FirstPreFilter firstPreFilter(){
//        return new FirstPreFilter();
//    }
//    @Bean
//    public SecondPreFilter secondPreFilter(){
//        return new SecondPreFilter();
//    }
//    @Bean
//    public ThirdPreFilter thirdPreFilter(){
//        return new ThirdPreFilter();
//    }
//    @Bean
//    public PostFilter postFilter() {
//        return new PostFilter();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerApplication.class, args);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/client/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable();
    }

}
