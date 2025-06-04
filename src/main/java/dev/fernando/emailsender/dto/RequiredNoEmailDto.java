package dev.fernando.emailsender.dto;

public record RequiredNoEmailDto(
    long idReference,
    String subject,
    String text
) {}
