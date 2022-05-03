package com.xiaofei.li.customFilterConfig;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;



/**
 * Author: xiaofei
 * Date: 2022-05-03, 0:42
 * Description:
 */
@Component
public class CheckParameterGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        System.out.println("name: "+config.getName()+", value: "+config.getValue());
        return new GatewayFilter() {
            String name = config.getName();
            String value = config.getValue();

            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String paramPass = exchange.getRequest().getQueryParams().getFirst(name);
                if (paramPass ==null|| paramPass.isEmpty()){
                    exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    exchange.getResponse().getHeaders().add("errorMessage",name+" parameter cannot be null");
                    return exchange.getResponse().setComplete();
                }

                if (!paramPass.equals(value)){
                    exchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
                    exchange.getResponse().getHeaders().add("errorMessage",name+" parameter not equal "+value);
                    return exchange.getResponse().setComplete();
                }
                return chain.filter(exchange);
            }
        };
    }
}
