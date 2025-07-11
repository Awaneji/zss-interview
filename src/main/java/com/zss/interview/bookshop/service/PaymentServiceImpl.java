package com.zss.interview.bookshop.service;

import com.zss.interview.bookshop.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    @Value("${payment.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public PaymentResponse makePayment() {
        return null;
    }
}
