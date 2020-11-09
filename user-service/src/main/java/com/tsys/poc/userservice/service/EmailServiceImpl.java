package com.tsys.poc.userservice.service;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendMail() throws MessagingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("awspoctsys@gmail.com", "Abc@12345");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("awspoctsys@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("shubhamsinghal70@gmail.com"));
        msg.setSubject("Tutorials point email");
        msg.setContent("Tutorials point email 2", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("Tutorials point email 2", "text/html");
//
//		Multipart multipart = new MimeMultipart();
//		multipart.addBodyPart(messageBodyPart);
//		MimeBodyPart attachPart = new MimeBodyPart();
//
//		attachPart.attachFile("/var/tmp/image19.png");
//		multipart.addBodyPart(attachPart);
//		msg.setContent(multipart);
        Transport.send(msg);

    }

}
