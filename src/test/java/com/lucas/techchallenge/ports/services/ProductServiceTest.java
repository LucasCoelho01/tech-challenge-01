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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    @DisplayName("Get all products")
    void shouldGetAllProductsTest() {
        Product product = new Product();
        product.setId(1L);
        product.setProductName("Refrigerante");
        product.setProductPrice(new BigDecimal(3.5));

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(product);

        when(productRepository.findAll()).thenReturn(listOfProducts);

        var products = productService.getAllProducts();

        assertNotNull(products);
    }

    @Test
    @DisplayName("Edit product")
    void editProductTest() {
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Refrigerante");
        productDto.setProductPrice(new BigDecimal(3.5));

        ProductDto editedProductDto = new ProductDto();
        editedProductDto.setProductName("Refrigerante");
        editedProductDto.setProductPrice(new BigDecimal(4.25));

        Product editedProduct = new Product();
        editedProduct.setId(1L);
        editedProduct.setProductName("Refrigerante");
        editedProduct.setProductPrice(new BigDecimal(4.25));

        when(productRepository.findById(any(Long.class))).thenReturn(Optional.of(editedProduct));
        when(productRepository.save(any())).thenReturn(editedProduct);

        var returnedProduct = productService.editProduct(1L, editedProductDto);

        assertEquals(editedProduct.getId(), returnedProduct.getId());
        assertEquals(editedProduct.getProductName(), returnedProduct.getProductName());
        assertEquals(editedProduct.getProductPrice(), returnedProduct.getProductPrice());
    }
}
