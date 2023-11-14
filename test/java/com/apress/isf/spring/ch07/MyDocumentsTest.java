package com.apress.isf.spring.ch07;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Sang Jun Park on 11/13/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch07/mydocuments-context-ch07.xml")
public class MyDocumentsTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);

    @Autowired
    private SearchEngine engine;

    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringTest(){
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
    }
}
