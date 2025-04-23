package dev.fernando.emailsender.dto;

public record RequiredEmailDto(
        String emailTo,
        String name,
        String subject,
        String text
){}
