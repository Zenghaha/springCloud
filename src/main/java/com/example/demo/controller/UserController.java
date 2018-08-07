package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiIgnore
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username")String username) {
        return userService.findUserByUserName(username);
    }

    @ApiOperation(value = "用户列表",notes = "用户列表")
    @GetMapping(value = {""})
    public List<User> getUsers() {
        return userService.findAll();
    }

    @ApiOperation(value = "创建用户",notes = "创建用户")
    @PostMapping(value = "")
    public User saveUsers(User user) {
        return userService.saveUser(user);
    }
}
