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

public class MyDocumentsWithResourceInjectionTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("META-INF/ch06/mydocuments-resource-injection-context.xml");
    }

    @Test
    public void testMenu(){
        log.debug("Calling the Menu as Resource Injection:");
        Menu menu = context.getBean(Menu.class);
        assertNotNull(menu);
        menu.printMenu();
    }
}
