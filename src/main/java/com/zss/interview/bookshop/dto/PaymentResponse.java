package com.zss.interview.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse implements Serializable {

    private OffsetDateTime updated;
    private String responseCode;
    private String responseDescription;
    private String reference;
    private String debitReference;
}
