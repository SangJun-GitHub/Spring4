package com.apress.isf.spring.ch13.spring.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * Created by Sang Jun Park on 11/24/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Service
public class EmailService {

    @Autowired
    private MailSender mailSender;

    public void send(String from, String to, String subject, String message){
        sendEmail(from, to, subject, message);
    }

    private void sendEmail(String from, String to, String subject, String message){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}

