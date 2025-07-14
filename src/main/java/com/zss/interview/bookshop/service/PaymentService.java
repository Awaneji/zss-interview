package com.zss.interview.bookshop.service;

import com.zss.interview.bookshop.dto.PaymentRequestDTO;
import com.zss.interview.bookshop.dto.PaymentResponse;
import reactor.core.publisher.Mono;

public interface PaymentService {
    Mono<PaymentResponse> makePayment(PaymentRequestDTO request);
}
