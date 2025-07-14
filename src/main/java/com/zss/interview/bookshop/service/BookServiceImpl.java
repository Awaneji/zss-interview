package com.zss.interview.bookshop.service;

import com.zss.interview.bookshop.customexception.BookNotFoundException;
import com.zss.interview.bookshop.customexception.CategoryNotFoundException;
import com.zss.interview.bookshop.dto.BookRequestDTO;
import com.zss.interview.bookshop.dto.BookResponseDTO;
import com.zss.interview.bookshop.model.Book;
import com.zss.interview.bookshop.model.Category;
import com.zss.interview.bookshop.repository.BookRepository;
import com.zss.interview.bookshop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public BookResponseDTO getBookById(Long id) {
        return toResponseDTO(bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found")));
    }

    @Override
    public Page<BookResponseDTO> getBooksFilteredByCategory(String category, Pageable pageable) {
        Page<Book> books;

        if (category != null && !category.isBlank()) {
            books = bookRepository.findByCategoryTitleIgnoreCase(category, pageable);
        } else {
            books = bookRepository.findAll(pageable);
        }

        return books.map(this::toResponseDTO);
    }

    @Override
    public BookResponseDTO createBook(BookRequestDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Book book = new Book();

        book.setCategory(category);
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPrice(dto.getPrice());

        return toResponseDTO(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Book existing = bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(dto.getTitle());
                    book.setAuthor(dto.getAuthor());
                    book.setCategory(category);
                    book.setPrice(dto.getPrice());
                    return bookRepository.save(book);
                })
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        return toResponseDTO(existing);
    }

    private BookResponseDTO toResponseDTO(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPrice(),
                book.getCategory().getTitle(),
                book.getCreatedAt()
        );
    }
}
