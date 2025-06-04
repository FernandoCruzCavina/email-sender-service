package dev.fernando.emailsender.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import dev.fernando.emailsender.dto.CreateEmailLinkedDto;
import dev.fernando.emailsender.model.EmailLinkedInfo;
import dev.fernando.emailsender.repository.EmailLinkedInfoRepo;

@Component
public class EmailLinkedInfoConsumer {
    
    RabbitTemplate rabbitTemplate;
    EmailLinkedInfoRepo emailLinkedInfoRepo;

    @Autowired
    public EmailLinkedInfoConsumer(EmailLinkedInfoRepo emailLinkedInfoRepo){
        this.emailLinkedInfoRepo = emailLinkedInfoRepo;
    }

    @RabbitListener(queues = "${broker.queue.account.creation}")
    public void createEmailLinkedInfo(@Payload CreateEmailLinkedDto createEmailLinkedDto){
        var emailLinkedInfo = new EmailLinkedInfo(
            createEmailLinkedDto.userId(),
            createEmailLinkedDto.accountId(),
            createEmailLinkedDto.email()
        );

        emailLinkedInfoRepo.save(emailLinkedInfo);
        System.out.println("email info saved with email: " + emailLinkedInfo.getEmail());
    }
}
