package com.xiaofei.li.cloudconsulconfig;

import com.xiaofei.li.entity.StudentConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication (scanBasePackages = "com.xiaofei.li")
@EnableDiscoveryClient
@EnableConfigurationProperties({StudentConfig.class})
public class CloudConsulConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsulConfigApplication.class, args);
    }

}
