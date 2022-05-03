package com.xiaofei.li.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: xiaofei
 * Date: 2022-05-02, 13:32
 * Description:
 */
@RestController
@RequestMapping("/prefix/users")
public class PrefixUserController {
    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id){
        System.out.println("port 8001");
        return "prefix endpoint port number: 8001."+id+" user greeting you here";
    }
    @GetMapping("/semaphore/{id}")
    public String semaphoreMethod(@PathVariable Integer id){
        System.out.println(Thread.currentThread()+": before: UserController.semaphoreMethod");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+": after: UserController.semaphoreMethod");
        return "successfully invoke semaphore: "+id;
    }
    @GetMapping("/getHeader")
    public Map<String, String> getHeaderInfo(HttpServletRequest request){
        Map<String, String> map = new HashMap<>();
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements()){
            String name = headers.nextElement();
            String value = request.getHeader(name);
            map.put(name,value);
        }

        return map;
    }

    @GetMapping("/getResponse")
    public Map<String, String> getResponseInfo(HttpServletResponse response){
        Map<String, String> map = new HashMap<>();
        Collection<String> names = response.getHeaderNames();
        System.out.println(names);
        for (String name:names){
            map.put(name,response.getHeader(name));
        }
        return map;
    }

    @GetMapping("/thread/{id}")
    public String threadMethod(@PathVariable Integer id){
        System.out.println(Thread.currentThread()+": before: UserController.threadMethod");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+": after: UserController.threadMethod");
        return "successfully invoke thread: "+id;
    }

    @GetMapping("/circuit/{id}")
    public String circuitMethod(@PathVariable Integer id){
        System.out.println(Thread.currentThread()+": before: UserController.circuitMethod");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+": after: UserController.circuitMethod");
        return "successfully invoke circuit: "+id;
    }

    public String fallback(Integer id, Throwable throwable){
        System.out.println(Thread.currentThread().getName()+": before-UserController.fallback-");
        System.out.println(throwable.getMessage());
        System.out.println(Thread.currentThread().getName()+": after-UserController.fallback-");
        return "fallback executed:"+id;
    }

    @PostMapping("/upload")
    public String uploadTest(){
        return "success";
    }
}
