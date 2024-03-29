package com.lucas.techchallenge.ports.repositories;

import com.lucas.techchallenge.domain.Category;
import com.lucas.techchallenge.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategory(Category category);
}
