package com.zss.interview.bookshop.repository;

import com.zss.interview.bookshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}