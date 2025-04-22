package dev.fernando.emailsender.dto;

public record RequiredEmailDto(
        String email,
        String name,
        String subject,
        String text
) {
}
