package com.example.java_mail.service;

import com.example.java_mail.controller.EmailController;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class JavaMailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("supunsulak20@gmail.com");
            message.setTo("chandimanilanka80@gmail.com");
            message.setSubject("Simple test email from Supun Sulakshana");
            message.setText("This is a sample email body for my first email.");

            javaMailSender.send(message);
    }

    public void sendEmailWithAttachment() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("supunsulak20@gmail.com");
        helper.setTo("chandimanilanka80@gmail.com");
        helper.setSubject("Java email with attachment.");
        helper.setText("Please find the attached documents below.");

        helper.addAttachment("logo.png",new File("C:/Users/Supun Sulakshana/Pictures/err.png"));

        javaMailSender.send(message);
    }

    public void sendEmailWithHtmlBody() throws MessagingException, IOException {

        ClassPathResource resource = new ClassPathResource("templates/email-content.html");
        String html = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("supunsulak20@gmail.com");
        helper.setTo("chandimanilanka80@gmail.com");
        helper.setSubject("Java email with attachment.");
        helper.setText(html, true);


        javaMailSender.send(message);
    }
}
