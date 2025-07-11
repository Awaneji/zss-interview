package com.zss.interview.bookshop.dto;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO {
    private String title;
    private String author;
    private BigDecimal price;
    private Long categoryId;
}