package com.example.login.model;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LoginProcessor {

    private String username;


    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean logged_in() {

        boolean logged_in = false;

        if (Objects.equals(username, "sumit") && Objects.equals(password, "password")) {
           logged_in=true;
            return logged_in;
        }
        else return logged_in;
    }
}
