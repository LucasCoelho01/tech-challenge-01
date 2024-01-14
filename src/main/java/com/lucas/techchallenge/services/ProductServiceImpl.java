package com.lucas.techchallenge.services;

import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.ProductDto;
import com.lucas.techchallenge.ports.repositories.ProductRepository;
import com.lucas.techchallenge.ports.services.ProductService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;
    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product= productRepository.findById(id);

        return product.orElseThrow();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product editProduct(Long id, ProductDto productDto) {
        Product productFound = findById(id);
        productFound.setProductName(productDto.getProductName());
        productFound.setProductPrice(productDto.getProductPrice());
        return productRepository.save(productFound);
    }

    @Override
    public void deleteProduct(ProductDto productDto) {

    }
}
