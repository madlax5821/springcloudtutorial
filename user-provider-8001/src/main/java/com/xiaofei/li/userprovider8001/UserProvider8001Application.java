package com.xiaofei.li.userprovider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
@EnableEurekaClient
public class UserProvider8001Application {

    public static void main(String[] args) {
        SpringApplication.run(UserProvider8001Application.class, args);
    }

}
