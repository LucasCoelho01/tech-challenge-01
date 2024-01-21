package com.lucas.techchallenge.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucas.techchallenge.domain.dto.CategoryDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String categoryName;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category() {}

    public Category(CategoryDto categoryDto) {
        this.categoryName = categoryDto.getCategoryName();
    }
}
