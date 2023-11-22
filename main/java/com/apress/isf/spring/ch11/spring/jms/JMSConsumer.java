package com.apress.isf.spring.ch11.spring.jms;

import com.apress.isf.spring.ch11.java.model.Document;
import com.apress.isf.spring.ch11.java.utils.XmlUtils;
import com.apress.isf.spring.ch11.spring.data.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by Sang Jun Park on 11/21/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */
@Component
public class JMSConsumer implements MessageListener {
    @Autowired
    DocumentDAO documentDAO;
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try{
            Document document = XmlUtils.fromXML(textMessage.getText(), Document.class);
            documentDAO.save(document);
        }catch(JMSException e){
            e.printStackTrace();
        }
    }
}
