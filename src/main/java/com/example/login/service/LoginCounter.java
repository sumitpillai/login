package com.example.login.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCounter {

    private int number;

    public LoginCounter(int number) {
        this.number = number;
    }

    public LoginCounter() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public void increment(){
        this.number = this.number +1;
    }

}
