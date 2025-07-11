package com.zss.interview.bookshop.repository;

import com.zss.interview.bookshop.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findByCategoryTitleIgnoreCase(String category, Pageable pageable);
}