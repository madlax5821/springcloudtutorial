package com.xiaofei.li.cloudgateway6002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
@EnableDiscoveryClient
public class CloudGateway6002Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudGateway6002Application.class, args);
    }

}
