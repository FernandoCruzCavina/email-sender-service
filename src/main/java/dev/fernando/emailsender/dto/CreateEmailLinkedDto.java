package dev.fernando.emailsender.dto;

public record CreateEmailLinkedDto(
    long userId,
    long accountId,
    String email
) {}
