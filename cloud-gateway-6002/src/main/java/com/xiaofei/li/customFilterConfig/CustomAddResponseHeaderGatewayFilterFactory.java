package com.xiaofei.li.customFilterConfig;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * Author: xiaofei
 * Date: 2022-05-03, 0:33
 * Description:
 */
@Component
public class CustomAddResponseHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomAddResponseHeaderGatewayFilterFactory.Config>{
    public CustomAddResponseHeaderGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getResponse().getHeaders().add(config.getName(),config.getValue());
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private String name;
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}


