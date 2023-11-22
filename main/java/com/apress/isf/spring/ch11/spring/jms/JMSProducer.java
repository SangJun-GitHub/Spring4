package com.apress.isf.spring.ch11.spring.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Component("jmsProducer")
public class JMSProducer {

    @Value("classpath:META-INF/ch11/data/jms.txt")
    private Resource jmstxt;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(){
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(getMessage());
            }
        });
    }

    private String getMessage(){
        StringBuilder sb = new StringBuilder();
        try{
            InputStream stream = jmstxt.getInputStream();
            Scanner sc = new Scanner(stream);
            while(sc.hasNext()){
                sb.append(sc.nextLine());
            }
            sc.close();
            stream.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
