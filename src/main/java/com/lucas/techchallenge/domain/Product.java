package com.lucas.techchallenge.domain;

import com.lucas.techchallenge.domain.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal productPrice;

    public Product() {}

    public Product(ProductDto productDto) {
        this.productName = productDto.getProductName();
        this.productPrice = productDto.getProductPrice();
    }
}