package com.xiaofei.li.controller;

import com.xiaofei.li.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: xiaofei
 * Date: 2022-04-20, 20:40
 * Description:
 */
@RestController
@RequestMapping ("/users")
public class FeignController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }
}
