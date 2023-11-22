package com.apress.isf.spring.ch11.spring.amqp;

import com.apress.isf.spring.ch11.java.model.Document;
import com.apress.isf.spring.ch11.java.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component("rabbitmqConsumer")
public class RabbitMQConsumer implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Override
    public void onMessage(Message message) {
        Document document = XmlUtils.fromXML(new String(message.getBody()), Document.class);
        log.debug("Document received: " + document);
    }
}
