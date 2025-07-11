package com.zss.interview.bookshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Version
    private Integer version;

}
