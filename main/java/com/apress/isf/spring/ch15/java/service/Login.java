package com.apress.isf.spring.ch15.java.service;

/**
 * Created by Sang Jun Park on 12/04/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface Login {
    public boolean isAuthorized(String email, String pass);
}
