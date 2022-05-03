package com.xiaofei.li.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Author: xiaofei
 * Date: 2022-04-20, 18:28
 * Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RestTemplate loadBalancedTemplate;
    @Autowired
    @Qualifier ("noLoadBalancedTemplate")
    private RestTemplate noLoadBalancedTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/lb/{id}")
    public String getUserByIdOnServerOne(@PathVariable Integer id){
        //ServiceInstance instance = loadBalancerClient.choose("user-provider");
//        ServiceInstance instance = loadBalancerClient.choose("user-loadBalancer-consumer");
//        System.out.println("host: "+instance.getHost()+", port: "+instance.getPort()+", uri: "+instance.getUri()
//        +", service id: "+instance.getInstanceId()+", metadata: "+instance.getMetadata());
        System.out.println("port 9004");
        return loadBalancedTemplate.getForObject("http://user-provider/users/"+id,String.class,id);
    }

    @GetMapping("/lb/provider/{id}")
    public String getUserByIdOnServerTwo(@PathVariable Integer id){
        ServiceInstance instance = loadBalancerClient.choose("user-provider");
        System.out.println("host: "+instance.getHost()+", port: "+instance.getPort()+", uri: "+instance.getUri()
                +", service id: "+instance.getInstanceId()+", metadata: "+instance.getMetadata());
        return loadBalancedTemplate.getForObject("http://user-provider/users/"+id,String.class,id);
    }

    @GetMapping("/nolb/{id}")
    public String getUserByIdWithoutLB(@PathVariable Integer id){
        return noLoadBalancedTemplate.getForObject("http://localhost:8001/users/"+id,String.class,id);
    }
}
