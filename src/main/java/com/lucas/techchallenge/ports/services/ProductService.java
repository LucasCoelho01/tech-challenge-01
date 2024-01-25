package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Category;
import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDto productDto);

    Product findById(Long id);
    List<Product> getAllProducts();

    Product editProduct(Long id, ProductDto productDto) throws Exception;

    boolean deleteProduct(Long id);

    Product updateCategoryOfProduct(Product product, Long category_id);

    List<Product> listProductsByCategory(Long category_id);
}
