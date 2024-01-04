package com.apress.isf.spring.ch17.spring.amqp;

import com.apress.isf.spring.ch17.java.model.Document;

/**
 * Created by Sang Jun Park on 01/03/2024.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface RabbitMQConsumer {
    public void process(Document document);
}
