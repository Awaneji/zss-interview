package com.zss.interview.bookshop.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PageResponse<T> implements Serializable {

    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
    private T items;

    public PageResponse(Integer currentPage, Long totalItems, Integer totalPages, T items) {
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.items = items;
    }
}
