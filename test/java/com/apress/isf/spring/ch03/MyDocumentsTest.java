package com.apress.isf.spring.ch03;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by Sang Jun Park on 11/02/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MyDocumentsTest {

    private ClassPathXmlApplicationContext context;
    private SearchEngine engine;
    private Type webType;

    @Before
    public void setUp(){
        context = new ClassPathXmlApplicationContext("META-INF/mydocuments-context-ch03.xml");
        engine = context.getBean(SearchEngine.class);
        webType = context.getBean("webType", Type.class);
    }

    @Test
    public void testWithSpringFindByType(){
        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
    }

    @Test
    public void testWithSpringListAll(){
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
}
