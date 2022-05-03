package com.xiaofei.li.cloudconfigclient7002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
@EnableEurekaClient
public class CloudConfigClient7002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient7002Application.class, args);
    }

}
