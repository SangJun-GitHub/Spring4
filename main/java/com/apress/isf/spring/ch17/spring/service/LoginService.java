package com.apress.isf.spring.ch17.spring.service;

import com.apress.isf.spring.ch17.java.service.Login;

/**
 * Created by Sang Jun Park on 01/08/2024.
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
    @Override
    public boolean isAuthorized(String email, String pass) {
        if(username.equals(email) && password.equals(pass))
            return true;
        return false;
    }
}
