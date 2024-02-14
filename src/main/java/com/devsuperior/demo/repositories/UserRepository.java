package com.devsuperior.demo.repositories;

import com.devsuperior.demo.entities.User;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmailIgnoreCase(@Nonnull String email);
}
