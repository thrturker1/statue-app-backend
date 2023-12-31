package com.statusApp.statue.controller;

import com.statusApp.statue.entity.User;
import com.statusApp.statue.service.abstracts.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getOneUser(@PathVariable(required = true) long id){
        return userService.getOneUser(id);
    }

    @PostMapping("/post")
    public User postOneUser(@RequestBody(required = true) User user) {
        return userService.postOneUser(user);
    }

    @PutMapping("/{id}")
    public User putOneUser(@RequestBody(required = true) User user, @PathVariable(required = true) long id) {
        return userService.putOneUser(user, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOneUser(@PathVariable(required = true) long id) {
        userService.deleteOneUser(id);
    }
}
