package com.apress.isf.spring.ch01;

/**
 * Created by Sang Jun Park on 10/03/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class HelloWorldMessage implements MessageService{
    public String getMessage(){
        return "Hello World!";
    }
}
