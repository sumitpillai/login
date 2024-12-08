package com.example.login.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Service
public class UserNamePersist {
    private String username;

    public UserNamePersist(String username) {
        this.username = username;
    }

    public UserNamePersist() {
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

}
