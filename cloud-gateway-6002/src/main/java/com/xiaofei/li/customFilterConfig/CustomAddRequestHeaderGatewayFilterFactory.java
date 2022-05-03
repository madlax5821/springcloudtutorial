package com.xiaofei.li.customFilterConfig;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotEmpty;

/**
 * Author: xiaofei
 * Date: 2022-05-02, 23:57
 * Description:
 */
@Component
public class CustomAddRequestHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<CustomAddRequestHeaderGatewayFilterFactory.Config> {

    public CustomAddRequestHeaderGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate().header(config.getName(), config.getValue()).build();
            return chain.filter(exchange.mutate().request(request).build());
        };
    }
    @Validated
    public static class Config {
        @NotEmpty
        private String name;
        @NotEmpty
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
