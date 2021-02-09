package org.copydays.rmliu.cache.controller;

import org.copydays.rmliu.cache.entity.User;
import org.copydays.rmliu.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/find")
    User find(Integer id) {
//        return new User(1, "rmliu", 18);
        return userService.find(id);
    }

    @RequestMapping("/user/list")
    List<User> list() {
//        return Arrays.asList(new User(1, "rmliu", 18), new User(2, "tingting", 17));
        return userService.list();
    }

}
