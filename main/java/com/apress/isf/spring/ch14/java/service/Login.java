package com.apress.isf.spring.ch14.java.service;

/**
 * Created by Sang Jun Park on 11/28/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface Login {
    public boolean isAuthorized(String email, String pass);
}
