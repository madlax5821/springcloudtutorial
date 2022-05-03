package com.xiaofei.li.userconsumerloadbalancer9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
//@LoadBalancerClients(
//        defaultConfiguration = LoadBalancerClientConfiguration.class,
//        value = {
//                @LoadBalancerClient(name = "user-provider", configuration = LoadBalancerClientConfiguration.class),
//                @LoadBalancerClient(name = "user-provider2", configuration = LoadBalancerClientConfiguration.class)
//        }
//)
@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
@EnableEurekaClient
public class UserConsumerLoadBalancer9002Application {

    @Primary
    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate noLoadBalancedTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(UserConsumerLoadBalancer9002Application.class, args);
    }

}
