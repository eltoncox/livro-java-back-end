package com.elton.java.back.end.model.dto;

import com.elton.java.back.end.model.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {

    @NotBlank
    private String productIdentifier;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Float preco;

    @NotNull
    private CategoryDTO category;


    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public @NotNull CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(@NotNull CategoryDTO category) {
        this.category = category;
    }

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao()); // Corrigido para usar getDescricao()
        
        if (product.getCategory() != null) {
            productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
    }
}
