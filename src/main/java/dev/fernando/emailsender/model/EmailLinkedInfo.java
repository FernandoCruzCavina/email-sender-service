package dev.fernando.emailsender.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "EmailInfo")
public class EmailLinkedInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private long userId;
    @Column(unique = true)
    private long accountId;
    @Column(unique = true)
    private String email;

    public EmailLinkedInfo(long userId, long accountId, String email) {
        this.userId = userId;
        this.accountId = accountId;
        this.email = email;
    }
}