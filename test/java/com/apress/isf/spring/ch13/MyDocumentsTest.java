package com.apress.isf.spring.ch13;

import com.apress.isf.spring.ch13.spring.email.EmailService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Sang Jun Park on 11/25/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch13/mydocuments-context-ch13.xml")
public class MyDocumentsTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

    @Autowired
    EmailService email;

    @Test
    public void testScheduler() throws InterruptedException{
        Thread.sleep(45000);
    }

    @Test
    @Ignore
    public void testEmail() throws InterruptedException{
        log.debug("Testing Email...");
        assertNotNull(email);

        long start = new Date().getTime();
        email.send("user@gmail.com", "user@gmail.com", "New Document Add", "A new document was added to the collection.");
        long end = new Date().getTime();
        long time = (end - start)/1000;
        log.debug("Sending email done. Took: " + time + " seconds.");
    }

    @Test
    @Ignore
    public void testAsyncEmail() throws InterruptedException{
        log.debug("Test Async Email...");

        assertNotNull(email);

        long start = new Date().getTime();

        email.sendAsync("user@gmail.com", "user@gmail.com", "New Document Add", "A new document was to the collection.");

        long end = new Date().getTime();
        long time = (end - start) / 1000;

        log.debug("Sending Async email done. Took: " + time + " seconds.");
    }
}
