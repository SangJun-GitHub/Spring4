package com.apress.isf.spring.ch16.spring.amqp;

import com.apress.isf.spring.ch16.java.model.Document;

/**
 * Created by Sang Jun Park on 12/05/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

public interface RabbitMQConsumer {
    public void process(Document document);
}
