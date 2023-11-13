package com.apress.isf.spring.ch06;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Sang Jun Park on 11/12/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MydocumentsI18nTest {
    private static final Logger log = LoggerFactory.getLogger(MydocumentsI18nTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("META-INF/ch06/mydocuments-i18n-context-ch06.xml");
    }

    @Test
    public void testMenu(){
        log.debug("About to Translate...");
        String english = context.getMessage("main.title", null, Locale.ENGLISH);
        String spanish = context.getMessage("main.title", null, new Locale("es"));

        System.out.println("English: " + english);
        System.out.println("Spanish: " + spanish);
    }
}
