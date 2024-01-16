package com.lucas.techchallenge.ports.services;

import com.lucas.techchallenge.domain.Category;
import com.lucas.techchallenge.domain.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    Category createCategory(CategoryDto categoryDto);

    List<Category> listAllCategories();

    Category findById(Long id);
}
