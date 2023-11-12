package com.apress.isf.spring.ch04;

import com.apress.isf.spring.ch02.Document;
import com.apress.isf.spring.ch02.SearchEngine;
import com.apress.isf.spring.ch02.Type;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sang Jun Park on 11/08/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public class MyDocumentsBeanDefinitionReaderTest {
        private ApplicationContext context;
        private SearchEngine engine;
        private Type webType;

        @Before
        public void setup(){
            context = new GenericGroovyApplicationContext("META-INF/ch04/mydocuments-ch04.groovy");
            engine = context.getBean(SearchEngine.class);
            webType = context.getBean("webType",Type.class);
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
