package com.xiaofei.li.customPredicateConfig;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.function.Predicate;

/**
 * Author: xiaofei
 * Date: 2022-05-02, 20:43
 * Description:
 */
@Component
public class UsernameCheckRoutePredicateFactory extends AbstractRoutePredicateFactory<UsernameCheckRoutePredicateFactory.Config>{

    public UsernameCheckRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String username = serverWebExchange.getRequest().getQueryParams().getFirst("username");
                if (username==null||username.isEmpty()){
                    return false;
                }
                if (username.equals(config.getUsername())){
                    return true;
                }
                return false;
            }
        };
    }

    public static class Config {
        private String username;

        public Config() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
