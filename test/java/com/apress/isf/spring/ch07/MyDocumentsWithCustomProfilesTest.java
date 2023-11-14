package com.apress.isf.spring.ch07;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;
import com.apress.isf.spring.ch07.test.CustomProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.annotation.ProfileValueSourceConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sang Jun Park on 11/13/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch07/mydocuments-custom-profiles-context-ch07.xml")
@ProfileValueSourceConfiguration(CustomProfile.class)
public class MyDocumentsWithCustomProfilesTest {
    private static final Logger log = LoggerFactory.getLogger(MyDocumentsWithCustomProfilesTest.class);

    @Autowired
    private SearchEngine engine;
    @Autowired
    private Type webType;

    @IfProfileValue(name = "environment", value = "dev")
    @Test
    public void testUsingSpringTestWithCustomProfilesX(){
        try{
            log.debug("Using Spring Test fixtures:");

            List<Document> documents = engine.findByType(webType);
            assertNotNull(documents);
            assertTrue(documents.size() == 1);
            assertEquals(webType.getName(), documents.get(0).getType().getName());
            assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
            assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

            documents = engine.listAll();
            assertNotNull(documents);
            assertTrue(documents.size() == 4);
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }
    @IfProfileValue(name = "os.name", value = "Unix")
    @Test
    public void testUsingSpringTestWithCustomProfilesY(){
        try{
            log.debug("Using Spring Test fixtures on Unix:");

            List<Document> documents = engine.findByType(webType);
            assertNotNull(documents);
            assertTrue(documents.size() == 1);
            assertEquals(webType.getName(), documents.get(0).getType().getName());
            assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
            assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

            documents = engine.listAll();
            assertNotNull(documents);
            assertTrue(documents.size() == 4);
        } catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
