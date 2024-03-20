package com.example.onlineshop.repository;

import com.example.onlineshop.entity.Order;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Nonnull
    Optional<Order> findById(@Nonnull UUID id);

}
