package dev.fernando.emailsender.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Email {

    private String email_to;
    private String name;
    private String subject;
    private String text;
}
