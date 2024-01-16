package com.lucas.techchallenge.services;

import com.lucas.techchallenge.domain.Category;
import com.lucas.techchallenge.domain.dto.CategoryDto;
import com.lucas.techchallenge.ports.repositories.CategoryRepository;
import com.lucas.techchallenge.ports.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category(categoryDto);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> listAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        return category.orElse(new Category());
    }
}
