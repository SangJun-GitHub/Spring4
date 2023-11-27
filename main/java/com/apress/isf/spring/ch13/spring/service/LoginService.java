package com.apress.isf.spring.ch13.spring.service;

import com.apress.isf.spring.ch13.java.service.Login;

/**
 * Created by Sang Jun Park on 11/26/2023.
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
    public boolean isAuthorized(String email, String password) {
        return userName.equals(email) && this.password.equals(password);
    }
}
