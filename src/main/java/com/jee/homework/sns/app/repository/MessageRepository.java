package com.jee.homework.sns.app.repository;

import com.jee.homework.sns.app.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message,Long> {
}
