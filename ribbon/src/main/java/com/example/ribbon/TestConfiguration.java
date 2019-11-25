package com.example.ribbon;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.discovery.converters.Auto;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AvoidScan  //空的註解，為了指定特定的方法
public class TestConfiguration {

    @Bean
    public IClientConfig iClientConfig(){
        return new DefaultClientConfigImpl();
    }

    @Autowired
    IClientConfig iClientConfig;

    @Bean
    public IRule iRule(IClientConfig iClientConfig){
        return new RandomRule();//隨機選server
//        return new RoundRobinRule();//按順序選server
    }
}
