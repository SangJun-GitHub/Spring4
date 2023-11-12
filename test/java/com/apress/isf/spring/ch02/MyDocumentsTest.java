package com.apress.isf.spring.ch02;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sang Jun Park on 11/01/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MyDocumentsTest {
    //private SearchEngine engine = new MySearchEngine();

    private ClassPathXmlApplicationContext context;
    private SearchEngine engine;
    private Type documentType;

    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("META-INF/ch02/mydocuments-context-ch02.xml");
        engine = context.getBean(SearchEngine.class);
        documentType = context.getBean(Type.class);
    }
//    @Test
//    public void testFindByType(){
//        Type documentType = new Type();
//        documentType.setName("WEB");
//        documentType.setDesc("Web Link");
//        documentType.setExtension(".url");
//
//
//        List<Document> documents = engine.findByType(documentType);
//        assertNotNull(documents);
//        assertTrue(documents.size() == 1);
//        assertEquals(documentType.getName(), documents.get(0).getType().getName());
//        assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
//        assertEquals(documentType.getExtension(), documents.get(0).getType().getExtension());
//    }

//    @Test
//    public void testListAll(){
//        List<Document> documents = engine.listAll();
//        assertNotNull(documents);
//        assertTrue(documents.size() == 4);
//    }

    @Test
    public void testWithSpringFindByType(){
        List<Document> documents = engine.findByType(documentType);

        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(documentType.getName(), documents.get(0).getType().getName());
        assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(documentType.getExtension(), documents.get(0).getType().getExtension());
    }
    @Test
    public void testWithSpringListAll(){
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }
}
