package com.example.login.controller;

import com.example.login.service.LoginCounter;
import com.example.login.service.UserNamePersist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final UserNamePersist userNamePersist;
    private final LoginCounter loginCounter;

    public MainController(UserNamePersist userNamePersist, LoginCounter loginCounter) {
        this.userNamePersist = userNamePersist;
        this.loginCounter = loginCounter;
    }

    public UserNamePersist getUserNamePersist() {
        return userNamePersist;
    }




    @GetMapping("/main")
    public String main(@RequestParam(required = false)  String logout, Model page){
        if(logout != null){
            userNamePersist.setUsername(null);
            return "redirect:/";
        }

        page.addAttribute("username", userNamePersist.getUsername());
        page.addAttribute("logincounter", loginCounter.getNumber());
        return "landing_page.html";
    }
}
