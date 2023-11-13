package com.apress.isf.spring.ch06;

/**
 * Created by Sang Jun Park on 11/12/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class LoginService implements Login{
    private String username;
    private String password;

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password= password;
    }
    @Override
    public boolean isAuthorized(String email, String pass){
        return (username.equals(email) && password.equals(pass));
    }
}
