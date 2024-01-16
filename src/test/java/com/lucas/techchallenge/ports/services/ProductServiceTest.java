package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.ProductDto;
import com.lucas.techchallenge.ports.repositories.ProductRepository;
import com.lucas.techchallenge.services.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    public ProductRepository productRepository;

    @InjectMocks
    public ProductServiceImpl productService;

    @Test
    @DisplayName("Create a product")
    void shouldCreateProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Refrigerante");
        productDto.setProductPrice(new BigDecimal(3.5));

        when(productRepository.save(any(Product.class))).thenReturn(new Product(productDto));

        var product = productService.createProduct(productDto);

        assertEquals(productDto.getProductName(), product.getProductName());
        assertEquals(productDto.getProductPrice(), product.getProductPrice());

    }
}
