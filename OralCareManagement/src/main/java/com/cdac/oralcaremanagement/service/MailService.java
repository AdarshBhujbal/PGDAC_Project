package com.cdac.oralcaremanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromMail;

    public void sendMail(String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromMail);
        message.setTo(mail);
        message.setSubject("Welcome to Seth Dental Aura");
   
        // Plain text message
        String textMessage = "Dear user,\n\nYour registration is successfully done !!! ";
        message.setText(textMessage);

        mailSender.send(message);
    }
}
