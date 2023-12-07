package com.apress.isf.spring.ch16;

import com.apress.isf.spring.ch16.java.model.Document;
import com.apress.isf.spring.ch16.java.service.DocumentService;
import com.apress.isf.spring.ch16.spring.amqp.RabbitMQProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Sang Jun Park on 12/06/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/ch16/mydocuments-context-ch16.xml", "classpath:META-INF/ch16/mydocuments-mongo-context-ch16.xml"})
public class MydocumentsTest {

    private static final Logger log = LoggerFactory.getLogger(MydocumentsTest.class);

    @Autowired
    RabbitMQProducer rabbitmqProducer;

    @Autowired
    DocumentService documentFacade;

    @Test
    public void testProducer(){
        log.debug("Testing RabbitMQ Producer...");
        assertNotNull(rabbitmqProducer);
        assertNotNull(documentFacade);
        for(Document document : documentFacade.getAllDocuments()){
            rabbitmqProducer.send(document);
        }
    }

    @Test
    public void testJustWait() throws InterruptedException{
        Thread.sleep(5000);
    }


}
