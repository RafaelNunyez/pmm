package com.example.rafael.finalproject;

import java.io.Serializable;

public class User implements Serializable {

    String nickName;
    String password;

    public User () {}

    public User(String nickName, String password){
        this.nickName = nickName;
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}