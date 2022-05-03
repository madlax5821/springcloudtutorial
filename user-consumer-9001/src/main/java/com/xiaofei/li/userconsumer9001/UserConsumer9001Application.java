package com.xiaofei.li.userconsumer9001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
public class UserConsumer9001Application {


    @Bean
    public RestTemplate noLoadBalancedTemplate(){
        return new RestTemplate();
    }
    @Primary
    @Bean
    @LoadBalanced //default load balance is to split the requests evenly to every each provider one by one.
    public RestTemplate loadBalancedTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(UserConsumer9001Application.class, args);
    }

}
