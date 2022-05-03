package com.xiaofei.li.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Author: xiaofei
 * Date: 2022-05-02, 17:26
 * Description:
 */
@Configuration
public class RateLimitConfig {
    @Primary
    @Bean
    /*
    * configure key resolver
    * when we have multiple beans we need to use @Primary annotation for distinguishing or use annotation @Qualifier to
    * specify their names.
    * */
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest()
                .getPath()
                .toString()
        );
    }
        /*return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest()
                        .getPath()
                        .toString()
                );
            }*/
//        };
    @Bean
    public KeyResolver ipKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest()
                .getRemoteAddress()
                .getHostName());
    }

    @Bean
    public KeyResolver userKeyResolver(){
        return exchange -> Mono.just(exchange.getRequest()
                .getQueryParams()
                .getFirst("userId"));
    }
}
