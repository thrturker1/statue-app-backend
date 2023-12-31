package com.statusApp.statue.repository;

import com.statusApp.statue.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
