package com.tsys.poc.userservice.repository;

import com.tsys.poc.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
