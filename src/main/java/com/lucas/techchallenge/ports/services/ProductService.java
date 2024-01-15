package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(ProductDto productDto);

    Product findById(Long id);
    List<Product> getAllProducts();

    Product editProduct(Long id, ProductDto productDto) throws Exception;

    void deleteProduct(ProductDto productDto);
}
