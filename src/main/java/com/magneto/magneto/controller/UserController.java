package com.magneto.magneto.controller;

import com.magneto.magneto.dto.User;
import com.magneto.magneto.services.impl.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) { this.userService = userService;}

    @PostMapping("/user")
    public User login(@RequestBody User requestUser) {
        String token = userService.getJWTToken(requestUser.getUserName());
        User user = new User();
        user.setUserName(requestUser.getUserName());
        user.setToken(token);
        return user;
    }
}
