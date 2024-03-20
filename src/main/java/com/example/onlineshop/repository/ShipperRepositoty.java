package com.example.onlineshop.repository;

import com.example.onlineshop.entity.Shipper;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipperRepositoty extends JpaRepository<Shipper, String> {

    @Nonnull
    Optional<Shipper> findByName(@Nonnull String name);
}