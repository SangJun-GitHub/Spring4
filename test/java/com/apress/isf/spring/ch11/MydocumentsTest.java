package com.apress.isf.spring.ch11;

import com.apress.isf.spring.ch11.java.model.Document;
import com.apress.isf.spring.ch11.java.model.Type;
import com.apress.isf.spring.ch11.java.service.SearchEngine;
import com.apress.isf.spring.ch11.spring.amqp.RabbitMQProducer;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.apress.isf.spring.ch11.spring.jms.JMSProducer;

import static org.junit.Assert.*;
/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/ch11/mydocuments-context-ch11.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MydocumentsTest {

    private static final Logger log = LoggerFactory.getLogger(MydocumentsTest.class);
    private static final int MAX_ALL_DOCS = 5;
    private static final int MAX_WEB_DOCS = 2;
    private static final String DOCUMENT_ID = "df569fa4-a513-4252-9810-818cade184ca";

    @Autowired
    private SearchEngine engine;

    @Autowired
    JMSProducer jmsProducer;

    @Autowired
    RabbitMQProducer rabbitMQProducer;

    @Test
    public void testSpringJMS_1() {
        log.debug("Testing Spring JMS Producer...");
        jmsProducer.send();
    }

    @Test
    public void testSpringJMS_2() throws InterruptedException {
        log.debug("Testing Spring JMS Listener/Insert...");
        assertNotNull(engine);
        Thread.sleep(5000);
        assertEquals(MAX_ALL_DOCS, engine.listAll().size());

        Type documentType = new Type("WEB", ".url");
        assertEquals(MAX_WEB_DOCS, engine.findByType(documentType).size());
    }

    @Test
    public void testSpringRabbitMQ_1(){
        log.debug("Testing RabbitMQ producer...");
        assertNotNull(rabbitMQProducer);

        Document document = engine.findById(DOCUMENT_ID);
        assertNotNull(document);
        rabbitMQProducer.send(document);
    }
}
