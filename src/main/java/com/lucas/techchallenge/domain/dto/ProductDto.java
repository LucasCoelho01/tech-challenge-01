package com.lucas.techchallenge.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private String productName;
    private BigDecimal productPrice;
}
