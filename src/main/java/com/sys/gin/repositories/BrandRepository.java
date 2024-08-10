package com.sys.gin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sys.gin.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{}
