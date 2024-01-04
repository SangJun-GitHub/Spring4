package com.apress.isf.spring.ch17.spring.amqp;

import com.apress.isf.spring.ch17.java.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sang Jun Park on 01/03/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component("textConsumer")
public class TextDocumentsConsumer implements RabbitMQConsumer{
    private static final Logger log = LoggerFactory.getLogger(TextDocumentsConsumer.class);
    @Override
    public void process(Document document) {
        log.debug("Text Document received: " + document);
    }

}