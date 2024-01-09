package com.apress.isf.spring.ch16.java.service;

/**
 * Created by Sang Jun Park on 01/08/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface Login {
    public boolean isAuthorized(String email, String pass);
}
