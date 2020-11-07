package com.tsys.poc.userservice.controller;

import com.tsys.poc.userservice.entity.User;
import com.tsys.poc.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
public class UserController {

	@Autowired
    private UserService userService;


    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/readAll")
    public List<User> readAll() {
        return userService.getAll();
    }

    @GetMapping("/read/{username}")
    public User readByUsername(@PathVariable(name = "username") String username) {
        return userService.getById(username);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user, @RequestBody User updatedUser) {
        return userService.updateUser(user, updatedUser);
    }

    @DeleteMapping("/delete/{username}")
    public User deleteByUsername(@PathVariable(name = "username") String username) {
        return userService.deleteById(username);
    }


}
