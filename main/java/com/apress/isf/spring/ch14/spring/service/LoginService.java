package com.apress.isf.spring.ch14.spring.service;

import com.apress.isf.spring.ch14.java.service.Login;

/**
 * Created by Sang Jun Park on 11/28/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class LoginService implements Login {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAuthorized(String email, String pass) {
        return userName.equals(email) && pass.equals(password);
    }
}
