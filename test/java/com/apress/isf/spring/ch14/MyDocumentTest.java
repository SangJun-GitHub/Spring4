package com.apress.isf.spring.ch14;

import com.apress.isf.spring.ch14.spring.service.SecurityServiceFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Sang Jun Park on 11/29/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch14/mydocuments-context-ch14.xml")
public class MyDocumentTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentTest.class);

    private static String EMAIL = "john@email.com";
    private static String PASSWORD = "doe";

    @Autowired
    SecurityServiceFacade security;

    @Test
    public void testGroovy(){
        log.debug("Testing Security...");
        assertNotNull(security);
        assertTrue(security.areCredentialsValid(EMAIL, PASSWORD));
    }
}
