package com.apress.isf.spring.ch17;

import com.apress.isf.spring.ch17.spring.social.DocumentTweet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sang Jun Park on 01/15/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/ch17/mydocuments-context-ch17.xml","classpath:META-INF/ch17/mydocuments-mongo-context-ch17.xml"})
public class MydocumentsTest {
    private static final Logger log = LoggerFactory.getLogger(MydocumentsTest.class);

    @Autowired
    DocumentTweet documentTweet;

    @Test
    public void textTwitter(){
        log.debug("Testing Spring Social...");
        assertNotNull(documentTweet);
        documentTweet.tweet("Playing with Spring Social!");
    }
}
