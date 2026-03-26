package com.selex.bigOne.repository;

import com.selex.bigOne.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
