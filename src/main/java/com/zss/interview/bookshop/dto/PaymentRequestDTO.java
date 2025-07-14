package com.zss.interview.bookshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PaymentRequestDTO implements Serializable {

    @NotBlank(message = "Type is required")
    public String type;
    @NotBlank(message = "Extended Type is required")
    public String extendedType;
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Amount must have up to 10 integer digits and 2 decimal places")
    public BigDecimal amount;
    @JsonIgnore
    public String created;
    @NotNull(message = "Card details required")
    @Valid
    public Card card;
    @NotBlank(message = "Reference is required")
    public String reference;
    @NotBlank(message = "Narration is required")
    public String narration;
    public Map<String, Object> additionalData;

    public PaymentRequestDTO() {
        super();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Africa/Harare"));

        this.created = zonedDateTime.format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
        );
    }
}
