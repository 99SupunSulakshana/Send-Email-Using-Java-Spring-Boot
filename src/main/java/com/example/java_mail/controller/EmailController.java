package com.example.java_mail.controller;

import com.example.java_mail.service.JavaMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email")
public class EmailController {

    @Autowired
    private JavaMailService javaMailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(){
        try {
            javaMailService.sendEmail();
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while sending email: " + e.getMessage());
        }
    }

    @PostMapping("/send-with-attachment")
    public ResponseEntity<String> sendEmailWithAttachment(){
        try {
            javaMailService.sendEmailWithAttachment();
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while sending email: " + e.getMessage());
        }
    }

    @PostMapping("/send-with-html")
    public ResponseEntity<String> sendEmailWithHTML(){
        try {
            javaMailService.sendEmailWithHtmlBody();
            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error while sending email: " + e.getMessage());
        }
    }
}
