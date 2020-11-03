package com.example.accountmanagement.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.stereotype.Component;

@Component
public interface EmailService {
	public void sendMail() throws AddressException, MessagingException, IOException ;
}
