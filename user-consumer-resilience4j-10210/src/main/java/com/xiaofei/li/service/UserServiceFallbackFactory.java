package com.xiaofei.li.service;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Author: xiaofei
 * Date: 2022-04-22, 14:18
 * Description:
 */
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable cause) {
        return new UserService() {
            @Override
            public String getUserById(Integer id) {
                System.out.println(Thread.currentThread().getName()+": getUserById-------before");
                System.out.println("exception cause: "+cause.getMessage());
                System.out.println(Thread.currentThread().getName()+": getUserById-------after");
                return cause.getMessage();
            }

            @Override
            public String semaphoreMethod(Integer id) {
                System.out.println(Thread.currentThread().getName()+": UserServiceFallbackFactory.semaphoreMethod------before");
                System.out.println("exception cause: "+cause.getMessage());
                System.out.println(Thread.currentThread().getName()+": UserServiceFallbackFactory.semaphoreMethod------after");
                return cause.getMessage();
            }

            @Override
            public String threadMethod(Integer id) {
                System.out.println(Thread.currentThread().getName()+": UserServiceFallbackFactory.threadMethod------before");
                System.out.println("exception cause: "+cause.getMessage());
                System.out.println(Thread.currentThread().getName()+": UserServiceFallbackFactory.threadMethod------after");
                return cause.getMessage();
            }

            @Override
            public String circuitMethod(Integer id) {
                System.out.println(Thread.currentThread().getName()+": UserServiceFallbackFactory.circuitMethod------before");
                System.out.println("exception cause: "+cause.getMessage());
                System.out.println(Thread.currentThread().getName()+": UserServiceFallbackFactory.circuitMethod------after");
                return cause.getMessage();
            }
        };
    }
}
