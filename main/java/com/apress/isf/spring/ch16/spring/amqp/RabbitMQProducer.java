package com.apress.isf.spring.ch16.spring.amqp;

import com.apress.isf.spring.ch16.java.model.Document;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sang Jun Park on 12/05/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component("rabbitmqProducer")
public class RabbitMQProducer {

    private static final String EXCHANGE = "mydocuments";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Document document){
        rabbitTemplate.convertAndSend(EXCHANGE, document.getType().getExtension(), document);
    }
}
