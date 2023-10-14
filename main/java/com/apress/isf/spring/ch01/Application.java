package com.apress.isf.spring.ch01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sang Jun Park on 10/03/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Configuration
@ComponentScan
public class Application {
    @Bean
    MessageService helloWroldMessageService(){
        return new HelloWorldMessage();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessageService service = context.getBean(MessageService.class);

        System.out.println(service.getMessage());
    }
}
