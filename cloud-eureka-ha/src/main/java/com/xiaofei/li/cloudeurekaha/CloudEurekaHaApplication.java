package com.xiaofei.li.cloudeurekaha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaHaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurekaHaApplication.class, args);
    }

}
