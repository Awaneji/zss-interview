package com.zss.interview.bookshop.config;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Configuration
public class AppConfig {

    @Value("${payment.url}")
    private String paymentUrl;

    @Bean
    public WebClient getWebClient() throws SSLException {

        SslContext context = SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();

        HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(context));

        MultiValueMap<String, String> valueMap = new LinkedMultiValueMap<>();

        valueMap.add(ACCESS_CODE, zbAccessCode);
        valueMap.add(ACCESS_PASSWORD, zbPassword);
        valueMap.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

        return WebClient.builder()
                .baseUrl(paymentUrl)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .defaultHeaders(httpHeaders -> httpHeaders.addAll(valueMap))
                .build();
    }
}
