package com.example.login.controller;

import com.example.login.model.LoginProcessor;
import com.example.login.service.LoginCounter;
import com.example.login.service.UserNamePersist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;
    private final UserNamePersist userNamePersist;

    private final LoginCounter loginCounter;

    public LoginController(LoginProcessor loginProcessor, UserNamePersist userNamePersist, LoginCounter loginCounter) {
        this.loginProcessor = loginProcessor;
        this.userNamePersist = userNamePersist;
        this.loginCounter = loginCounter;
    }

    @GetMapping("/")
    public String loginGet(){
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model page){
        boolean logged_in;
        String message;

        System.out.println("username is "+ username);
        page.addAttribute("username", username);
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        logged_in = loginProcessor.logged_in();

        loginCounter.increment();

        if (logged_in){
            //message = "Logged in successfully";
            userNamePersist.setUsername(username);
            return "redirect:/main";
        }
        else {
            message = "Wrong username or password";
            page.addAttribute("message",message);
            return "login.html";
        }

    }
}
