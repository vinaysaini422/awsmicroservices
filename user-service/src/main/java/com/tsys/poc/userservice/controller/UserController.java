package com.tsys.poc.userservice.controller;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.add(user);
    }

    @PostMapping("/readAll")
    public List<User> readAll() {
        return userService.getAll();
    }

    @PostMapping("/read")
    public User readByUsername(@RequestBody String username) {
        return userService.getById(username);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user, @RequestBody User updatedUser) {
        return userService.updateUser(user, updatedUser);
    }

    @PostMapping("/delete")
    public User deleteByUsername(@RequestBody String username) {
        return userService.deleteById(username);
    }


}
