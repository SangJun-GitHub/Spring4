package com.apress.isf.spring.ch11.spring.amqp;

import com.apress.isf.spring.ch11.java.model.Document;
import com.apress.isf.spring.ch11.java.utils.XmlUtils;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Component("rabbitmqProducer")
public class RabbitMQProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Document document){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType("text/xml");
        byte[] body = XmlUtils.toXML(document).getBytes();
        Message message = new Message(body, messageProperties);
        rabbitTemplate.send(message);
    }
}
