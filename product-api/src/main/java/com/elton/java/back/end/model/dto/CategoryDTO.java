package com.elton.java.back.end.model.dto;

import com.elton.java.back.end.model.Category;

import javax.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private Long id;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setNome(categoryDTO.getNome());
        return categoryDTO;
    }
}
