package com.tsys.poc.userservice.service;

import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

@Component
public interface EmailService {
    public void sendMail() throws AddressException, MessagingException, IOException;
}
