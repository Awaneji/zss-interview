package com.zss.interview.bookshop.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Serializable {
    @NotBlank(message = "Card id is required")
    public String id;
    @NotNull(message = "Expiry date must not be null")
    @Future(message = "Expiry date must be in the future")
    public LocalDate expiry;
}