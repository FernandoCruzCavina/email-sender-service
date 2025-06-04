package dev.fernando.emailsender.dto;

public record RequiredEmailDto(
        String emailTo,
        String subject,
        String text
){}
