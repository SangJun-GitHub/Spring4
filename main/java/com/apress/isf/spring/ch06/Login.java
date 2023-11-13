package com.apress.isf.spring.ch06;

/**
 * Created by Sang Jun Park on 11/12/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface Login {
    public boolean isAuthorized(String email, String password);
}
