package com.apress.isf.spring.ch16.spring.service;

import com.apress.isf.spring.ch16.java.service.Login;

/**
 * Created by Sang Jun Park on 12/11/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class LoginService implements Login {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isAuthorized(String email, String pass){
        if(username.equals(email) && password.equals(pass))
            return true;
        return false;
    }

}
