package com.xiaofei.li.cloudeureka6001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
@EnableEurekaServer
public class CloudEureka6001Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudEureka6001Application.class, args);
    }

}
