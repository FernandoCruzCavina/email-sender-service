package dev.fernando.emailsender.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Value("${broker.queue.email.sender}")
    public String emailQueue;

    @Value("${broker.queue.account.email.sender}")
    private String emailLinkedInfoQueue;

    @Value("${broker.queue.account.creation}")
    private String accountCreationQueue;

    @Bean
    public Queue emailQueue() {
        return new Queue(emailQueue, true);
    }

    @Bean
    public Queue emailLinkedInfoQueue(){
        return new Queue(emailLinkedInfoQueue, true);
    }
    @Bean Queue accountCreationQueue(){
        return new Queue(accountCreationQueue, true);
    }

    @Bean
    public Jackson2JsonMessageConverter objectMapper(){

        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

}

