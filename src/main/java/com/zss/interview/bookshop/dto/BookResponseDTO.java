package com.zss.interview.bookshop.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookResponseDTO implements Serializable {
    private Long id;
    private String title;
    private String author;
    private BigDecimal price;
    private String categoryTitle;
    private LocalDateTime createTime;
}

