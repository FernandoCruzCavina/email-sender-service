package dev.fernando.emailsender.service;

import dev.fernando.emailsender.dto.RequiredEmailDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Value("spring.mail.username")
    private String emailFrom;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Transactional
    public void sendEmail(RequiredEmailDto requiredEmailDto) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(requiredEmailDto.emailTo());
        message.setFrom(emailFrom);
        message.setSubject(requiredEmailDto.subject());
        message.setText(requiredEmailDto.text());

        javaMailSender.send(message);
    }
}
