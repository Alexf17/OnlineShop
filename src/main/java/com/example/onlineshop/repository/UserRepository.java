package com.example.onlineshop.repository;

import com.example.onlineshop.entity.User;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    @Nonnull
    @Override
   Optional<User> findById(@Nonnull UUID id);
}
