package com.lucas.techchallenge.controllers;

import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.ProductDto;
import com.lucas.techchallenge.ports.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        Product product = productService.findById(id);

        if (Objects.isNull(product.getId())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<?> editProduct(@PathVariable Long id, @RequestBody ProductDto productDto) throws Exception {
        Product editedProduct = productService.editProduct(id, productDto);

        if (Objects.isNull(editedProduct.getId())) {
            return new ResponseEntity<>("Product not found", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(editedProduct, HttpStatus.OK);
    }

    @PutMapping("/id/update/category/{id}/{category_id}")
    public ResponseEntity<?> updateCategoryOfProduct(@PathVariable Long id, @PathVariable Long category_id) throws Exception {
        Product productFound = productService.findById(id);

        if (Objects.isNull(productFound.getId())) {
            return new ResponseEntity<>("Product not found", HttpStatus.NO_CONTENT);
        }

        Product updatedProduct = productService.updateCategoryOfProduct(productFound, category_id);

        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        boolean productWasDeleted = productService.deleteProduct(id);

        if (productWasDeleted) {
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("Product not found", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/category_id/{category_id}")
    public ResponseEntity<?> listProductsByCategory(@PathVariable Long category_id) {
        return new ResponseEntity<>(productService.listProductsByCategory(category_id), HttpStatus.OK);
    }
}
