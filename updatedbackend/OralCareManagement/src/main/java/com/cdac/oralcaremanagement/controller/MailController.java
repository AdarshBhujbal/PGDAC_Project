package com.cdac.oralcaremanagement.controller;

import com.cdac.oralcaremanagement.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/send/{mail}")
    public String sendMail(@PathVariable String mail) {
        // Send mail
        mailService.sendMail(mail);

        // Return a simple message
        return "Mail with OTP sent successfully";
    }
}
