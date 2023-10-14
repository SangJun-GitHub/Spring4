package com.apress.isf.spring.ch01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Sang Jun Park on 10/03/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Controller
@EnableAutoConfiguration
public class HelloWorldController {
    @RequestMapping("/")
    @ResponseBody
    public String getMessage(){
        return "<h1>Hello World!</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldController.class);
    }
}
