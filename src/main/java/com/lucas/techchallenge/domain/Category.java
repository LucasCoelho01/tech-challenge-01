package com.lucas.techchallenge.domain;

import com.lucas.techchallenge.domain.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String categoryName;

    public Category() {}

    public Category(CategoryDto categoryDto) {
        this.categoryName = categoryDto.getCategoryName();
    }
}
