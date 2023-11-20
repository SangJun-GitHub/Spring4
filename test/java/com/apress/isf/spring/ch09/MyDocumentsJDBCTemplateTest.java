package com.apress.isf.spring.ch09;

import com.apress.isf.spring.ch09.model.Document;
import com.apress.isf.spring.ch09.model.Type;
import com.apress.isf.spring.ch09.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by Sang Jun Park on 11/20/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch09/mydocuments-jdbc-template-context-ch09.xml")
public class MyDocumentsJDBCTemplateTest {

    @Autowired
    private SearchEngine engine;
    private Type webType = new Type("WEB", ".url");

    @Test
    public void testJDBCTemplate(){
        List<Document> documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);

        documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
    }
}
