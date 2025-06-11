package dev.fernando.emailsender.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import dev.fernando.emailsender.dto.RequiredEmailDto;
import dev.fernando.emailsender.dto.RequiredNoEmailDto;
import dev.fernando.emailsender.model.EmailLinkedInfo;
import dev.fernando.emailsender.repository.EmailLinkedInfoRepo;
import dev.fernando.emailsender.service.EmailService;

@Component
public class EmailConsumer {

    private final EmailService emailService;
    EmailLinkedInfoRepo emailLinkedInfoRepo;

    @Autowired
    public EmailConsumer(EmailService emailService, EmailLinkedInfoRepo emailLinkedInfoRepo) {
        this.emailService = emailService;
        this.emailLinkedInfoRepo = emailLinkedInfoRepo;
    }

    @RabbitListener(queues = "${broker.queue.email.sender}")
    public void sendEmailWithEmail(@Payload RequiredEmailDto requiredEmailDto) {
        System.out.println(requiredEmailDto.emailTo());
        emailService.sendEmail(requiredEmailDto);
    }

    @RabbitListener(queues = "${broker.queue.account.email.sender}")
    public void sendEmailWithoutEmail(@Payload RequiredNoEmailDto requiredNoEmailDto){
        EmailLinkedInfo emailInfo = emailLinkedInfoRepo.findByAccountId(requiredNoEmailDto.idReference())
                .orElseThrow(() -> new RuntimeException("account id not find one reference"));
        
        RequiredEmailDto emailDto = new RequiredEmailDto(
            emailInfo.getEmail(),
            requiredNoEmailDto.subject(),
            requiredNoEmailDto.text()
        );
        
        emailService.sendEmail(emailDto);
    }
}
