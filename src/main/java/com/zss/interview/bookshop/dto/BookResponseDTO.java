package com.zss.interview.bookshop.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private String categoryTitle;
}

