package com.apress.isf.spring.ch16.spring.amqp;

import com.apress.isf.spring.ch16.java.model.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Sang Jun Park on 12/05/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Component("pdfConsumer")
public class PdfDocumentsConsumer implements RabbitMQConsumer{

    private static final Logger log = LoggerFactory.getLogger(PdfDocumentsConsumer.class);

    @Override
    public void process(Document document) {
        log.debug("PDF Document received: " + document);
    }
}
