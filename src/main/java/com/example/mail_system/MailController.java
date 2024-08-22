package com.example.mail_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")
    public String sendMail(@RequestBody MailDetailsDTO mailDetailsDTO) {

        try {
            if (mailDetailsDTO.getToMail() == null || mailDetailsDTO.getToMail().isEmpty()) {
                return "To mail is required";
            }
            if (mailDetailsDTO.getSubject() == null || mailDetailsDTO.getSubject().isEmpty()) {
                return "Subject is required";
            }
            if (mailDetailsDTO.getMessage() == null || mailDetailsDTO.getMessage().isEmpty()) {
                return "Message is required";
            }
            if (mailDetailsDTO.getFromMail() == null || mailDetailsDTO.getFromMail().isEmpty()) {
                return "From mail is required";
            }

            SimpleMailMessage message = new SimpleMailMessage();


            message.setFrom(mailDetailsDTO.getFromMail()); // Set from mail

            message.setTo(mailDetailsDTO.getToMail()); // Set to mail
            message.setSubject(mailDetailsDTO.getSubject()); // Set subject of mail
            message.setText(mailDetailsDTO.getMessage()); // Set message of mail

            // Send mail
            javaMailSender.send(message);

            return "Mail sent successfully";

        } catch (Exception e) {
            return "Error occurred while sending mail"+e.getMessage();
        }



    }
}
