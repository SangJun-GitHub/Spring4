package com.apress.isf.spring.ch06;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sang Jun Park on 11/12/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MyDocumentsWithLoginTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithLoginTest.class);
    private static final String EMAIL = "test@mydocuments.com";
    private static final String PASSWORD = "test123";
    private static final String SUCCESS = "This user is authorized";
    private static final String FAILURE = "WARNING! This user is not authorized!";
    private ClassPathXmlApplicationContext context;

    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("META-INF/ch06/mydocuments-login-context-ch06.xml");
    }

    @Test
    public void testLogin(){
        log.debug("Login test.");
        Login login = context.getBean(Login.class);
        assertNotNull(login);
        if(login.isAuthorized(EMAIL, PASSWORD)) {
            System.out.println(SUCCESS);
        }else {
            System.out.println(FAILURE);
        }
    }
}
