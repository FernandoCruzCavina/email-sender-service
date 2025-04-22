package dev.fernando.emailsender.consumer;

import dev.fernando.emailsender.dto.RequiredEmailDto;
import dev.fernando.emailsender.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AccountConsumer {

    private final EmailService emailService;

    public AccountConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.sender}")
    public void consumeMessage(@Payload RequiredEmailDto requiredEmailDto) {
        emailService.sendEmail(requiredEmailDto);
    }
}
