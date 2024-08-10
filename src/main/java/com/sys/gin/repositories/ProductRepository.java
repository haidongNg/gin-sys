package com.sys.gin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sys.gin.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {}
