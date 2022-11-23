package com.dev.activitytracker.controllers;



import com.dev.activitytracker.pojos.User;
import com.dev.activitytracker.repository.UserRepository;
import com.dev.activitytracker.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    UserService userService;
    @PostMapping("/save")
    public User saveUser(@RequestBody User users){
        return userService.saveUser(users);
    }
}
