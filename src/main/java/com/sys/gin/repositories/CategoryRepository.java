package com.sys.gin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sys.gin.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {}
