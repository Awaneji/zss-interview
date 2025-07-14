package com.zss.interview.bookshop.service;

import com.zss.interview.bookshop.dto.BookRequestDTO;
import com.zss.interview.bookshop.dto.BookResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Page<BookResponseDTO> getBooksFilteredByCategory(String category, Pageable pageable);

    BookResponseDTO createBook(BookRequestDTO dto);

    BookResponseDTO updateBook(Long id, BookRequestDTO dto);

    BookResponseDTO getBookById(Long id);
}
