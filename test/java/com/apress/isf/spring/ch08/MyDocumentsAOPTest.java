package com.apress.isf.spring.ch08;

import com.apress.isf.spring.ch02.Document;
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
 * Created by Sang Jun Park on 11/14/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch08/mydocuments-aop-context-ch08.xml")
public class MyDocumentsAOPTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsAOPTest.class);

    @Autowired
    private SearchEngine engineProxy;

    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringAOP(){
        log.debug("Using Spring AOP");

        List<Document> documents = engineProxy.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

        documents = engineProxy.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);

        try{
            engineProxy.findByLocation("/some/path/");
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
