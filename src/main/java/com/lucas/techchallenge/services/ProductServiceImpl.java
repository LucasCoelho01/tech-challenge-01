package com.lucas.techchallenge.services;

import com.lucas.techchallenge.domain.Category;
import com.lucas.techchallenge.domain.Product;
import com.lucas.techchallenge.domain.dto.ProductDto;
import com.lucas.techchallenge.ports.repositories.ProductRepository;
import com.lucas.techchallenge.ports.services.CategoryService;
import com.lucas.techchallenge.ports.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;
    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product(productDto);
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id){
        Optional<Product> product= productRepository.findById(id);

        return product.orElse(new Product());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product editProduct(Long id, ProductDto productDto){
        Product productFound = findById(id);

        if (Objects.isNull(productFound.getId())) {
            return productFound;
        }

        productFound.setProductName(productDto.getProductName());
        productFound.setProductPrice(productDto.getProductPrice());
        return productRepository.save(productFound);
    }

    @Override
    public boolean deleteProduct(Long id) {
        Product productFound = findById(id);

        if (Objects.isNull(productFound.getId())) {
            return false;
        }

        productRepository.delete(productFound);
        return true;
    }

    @Override
    public Product updateCategoryOfProduct(Product product, Long category_id) {
        Category category = categoryService.findById(category_id);

        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public List<Product> listProductsByCategory(Long category_id) {
        Category category = categoryService.findById(category_id);

        return productRepository.findAllByCategory(category);
    }
}
