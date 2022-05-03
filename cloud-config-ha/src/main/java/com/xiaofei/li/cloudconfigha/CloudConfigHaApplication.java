package com.xiaofei.li.cloudconfigha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class CloudConfigHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigHaApplication.class, args);
    }

}
