package com.zss.interview.bookshop.service;

import com.zss.interview.bookshop.customexception.PaymentException;
import com.zss.interview.bookshop.dto.PaymentRequestDTO;
import com.zss.interview.bookshop.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    private final WebClient webClient;

    @Override
    public Mono<PaymentResponse> makePayment(PaymentRequestDTO request) {
        log.info("Payment request: {}", request);

        try {
            return webClient.mutate()
                    .build()
                    .post()
                    .uri("/api/transactions")
                    .body(Mono.just(request), PaymentRequestDTO.class)
                    .retrieve()
                    .onStatus(HttpStatusCode::is5xxServerError, resp ->
                            Mono.error(new PaymentException("Payment Error " + resp.statusCode().value()))
                    )
                    .bodyToMono(PaymentResponse.class)
                    .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(5))
                            .filter(ex -> ex instanceof PaymentException)
                    )
                    .doOnNext(response -> log.info("Payment response: {}", response))
                    .doOnError(error -> log.error("An error occurred processing payment: {}", error.getMessage()));

        } catch (Exception e) {
            log.info("An error has occurred processing payment: {}", e.getMessage());
            throw new PaymentException("An error has occurred processing payment: " + e.getMessage());
        }
    }

}
