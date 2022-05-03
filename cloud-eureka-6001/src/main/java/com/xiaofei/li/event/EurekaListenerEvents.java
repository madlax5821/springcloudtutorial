package com.xiaofei.li.event;

import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Author: xiaofei
 * Date: 2022-04-20, 0:14
 * Description:
 */
@Component
public class EurekaListenerEvents {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event){
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String ip = instanceInfo.getIPAddr();
        String instanceId = instanceInfo.getInstanceId();
        logger.info("id: "+instanceId+" has already registered on Eureka server ip: "+ip);
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String id = instanceInfo.getInstanceId();
        logger.info(">>>>>>>>"+id+"续约事件触发...");
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        logger.info(">>>>>>>>注册中心启动事件触发...");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        logger.info(">>>>>>>>EurekaServer启动事件触发...");
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        String id = event.getServerId();
        logger.info(">>>>>>>>"+id+"从Eureka下线...");
    }
}
