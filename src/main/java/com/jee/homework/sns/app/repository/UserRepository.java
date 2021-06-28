package com.jee.homework.sns.app.repository;

import com.jee.homework.sns.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
