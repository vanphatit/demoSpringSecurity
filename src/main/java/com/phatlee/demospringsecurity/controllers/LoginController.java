package com.phatlee.demospringsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("login")
    public String index() {
        return "login";
    }

    @GetMapping("user/profile")
    public String profile() {
        return "profile";
    }
}