package dev.fernando.emailsender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Email {

    private String email_to;
    private String subject;
    private String text;
}
