package com.example.onlineshop.repository;

import com.example.onlineshop.entity.Product;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductsRepository extends JpaRepository<Product, UUID> {
//    @Nonnull
//    List<Product> findAll();
}
