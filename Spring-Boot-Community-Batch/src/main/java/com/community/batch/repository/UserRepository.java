package com.community.batch.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.community.batch.domain.User;
import com.community.batch.domain.enums.UserStatus;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByUpdatedDateBeforeAndStatusEquals(LocalDateTime localDateTime, UserStatus status);
}
