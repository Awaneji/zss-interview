package com.zss.interview.bookshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;  //TODO can add an author model
    private BigDecimal price;  //TODO can add a shopping cart

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Version
    private Integer version;
}