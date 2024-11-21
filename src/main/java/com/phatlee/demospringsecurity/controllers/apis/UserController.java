package com.phatlee.demospringsecurity.controllers.apis;

import com.phatlee.demospringsecurity.entities.UserInfo;
import com.phatlee.demospringsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/new")
    public String newUser(@RequestBody UserInfo UserInfo) {
        return userService.addUser(UserInfo);
    }
}
