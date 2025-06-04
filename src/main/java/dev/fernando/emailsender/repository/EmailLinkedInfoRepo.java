package dev.fernando.emailsender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.fernando.emailsender.model.EmailLinkedInfo;

public interface EmailLinkedInfoRepo extends JpaRepository<EmailLinkedInfo, Long> {
    Optional<EmailLinkedInfo> findByAccountId(long accountId);
}
