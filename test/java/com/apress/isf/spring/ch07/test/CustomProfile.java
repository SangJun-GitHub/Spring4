package com.apress.isf.spring.ch07.test;

import org.springframework.test.annotation.ProfileValueSource;

/**
 * Created by Sang Jun Park on 11/13/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class CustomProfile implements ProfileValueSource{
    @Override
    public String get(String key) {
        if(key.equals("environment"))
            return "dev";
        else if(key.equals("os.name"))
            return "Unix";
        return null;
    }
}
