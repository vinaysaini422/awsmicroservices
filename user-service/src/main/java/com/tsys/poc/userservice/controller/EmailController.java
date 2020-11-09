package com.tsys.poc.userservice.controller;

import com.tsys.poc.userservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/send")
    String sendEmail() throws AddressException, MessagingException, IOException {
        emailService.sendMail();
        return "Email sent successfully";
    }
}
