package com.apress.isf.spring.ch13.java.service;

/**
 * Created by Sang Jun Park on 11/26/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface Login {
    public boolean isAuthorized(String email, String password);
}
