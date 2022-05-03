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
 * Date: 2022-04-19, 17:46
 * Description:
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier ("noLoadBalancedTemplate")
    private RestTemplate noLoadBalancedTemplate;
    @Autowired
    private RestTemplate loadBalancedTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/nolb/{id}")
    // must use the specific url address to apply for no load balance service call
    public String getUserById(@PathVariable Integer id){
        return noLoadBalancedTemplate.getForObject("http://localhost:8001/users/"+id, String.class, id);
    }

    @GetMapping("/lb/{id}")
    // on the other hand, due to the features of load balance, specific url and port name cannot be specified.
    public String getUserByIdByLoadBalancing(@PathVariable Integer id){
        ServiceInstance instance = loadBalancerClient.choose("user-provider");
        System.out.println("host: "+instance.getHost()+", port: "+instance.getPort()+", service id: "+instance.getInstanceId()
        +", uri: "+instance.getUri()+", metadata: "+instance.getMetadata());
        return loadBalancedTemplate.getForObject("http://user-provider/users/"+id, String.class, id);
    }
}
