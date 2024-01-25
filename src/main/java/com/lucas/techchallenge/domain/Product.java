package com.lucas.techchallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lucas.techchallenge.domain.dto.ProductDto;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal productPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Product() {}

    public Product(ProductDto productDto) {
        this.productName = productDto.getProductName();
        this.productPrice = productDto.getProductPrice();
    }
}