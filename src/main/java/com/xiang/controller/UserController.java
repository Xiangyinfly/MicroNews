package com.xiang.controller;

import com.xiang.pojo.User;
import com.xiang.service.UserService;
import com.xiang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        Result result = userService.login(user);
        return result;
    }

    public Result getUserInfo(@RequestBody String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }


}
