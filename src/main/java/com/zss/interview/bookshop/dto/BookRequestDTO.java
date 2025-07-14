package com.zss.interview.bookshop.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDTO implements Serializable {
    @NotBlank(message = "Book title is required.")
    private String title;
    @NotBlank(message = "Book author is required.")
    private String author;
    @NotNull(message = "Price must not be null")
    @DecimalMin(value = "0.01", message = "Price must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Price must have up to 10 integer digits and 2 decimal places")
    private BigDecimal price;
    @NotNull(message = "Order ID must not be null")
    @Min(value = 1, message = "Order ID must be at least 1")
    private Long categoryId;
}