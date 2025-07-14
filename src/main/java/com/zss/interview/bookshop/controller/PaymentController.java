package com.zss.interview.bookshop.controller;

import com.zss.interview.bookshop.dto.PaymentRequestDTO;
import com.zss.interview.bookshop.dto.PaymentResponse;
import com.zss.interview.bookshop.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public Mono<ResponseEntity<PaymentResponse>> makePayment(@RequestBody @Valid PaymentRequestDTO request) {
        log.info("Make payment request: {}", request);
        return paymentService.makePayment(request).map(paymentResponse -> ResponseEntity.ok().body(paymentResponse));
    }
}
