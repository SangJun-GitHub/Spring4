package com.apress.isf.spring.ch14.spring.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Sang Jun Park on 11/30/2023.
 * GitHub : http://github.com/SangJun-GitHub
 */

@Service
public class EmailService {

    @Autowired
    private MailSender mailSender;

    public void send(String from, String to, String subject, String message) {
        sendEmail(from, to, subject, message);
    }

    @Async
    public void sendAsync(String from, String to, String subject, String message) {
        sendEmail(from,to,subject,message);
    }

    private void sendEmail(String from, String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
