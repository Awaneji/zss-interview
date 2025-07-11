package com.zss.interview.bookshop.controller;

import com.zss.interview.bookshop.dto.BookRequestDTO;
import com.zss.interview.bookshop.dto.BookResponseDTO;
import com.zss.interview.bookshop.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @GetMapping
    public ResponseEntity<Page<BookResponseDTO>> getBooks(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.getBooksFilteredByCategory(category, pageable));
    }
}

