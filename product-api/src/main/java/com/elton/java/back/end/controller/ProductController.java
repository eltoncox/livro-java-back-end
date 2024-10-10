package com.elton.java.back.end.controller;

import com.elton.java.back.end.model.dto.ProductDTO;
import com.elton.java.back.end.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getProducts() {
        List<ProductDTO> produtos = productService.getAll();
        return produtos;
    }

    @GetMapping("/product/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {

        List<ProductDTO> produtos = productService.getProductByCategoryId(categoryId);

        return produtos;
    }

    @GetMapping("/product/{productIdentifier}")
    public ResponseEntity<ProductDTO> findById(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping("/product")
    ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("product/{id}")
    ProductDTO delete(@PathVariable Long id) {
        return productService.delete(id);
    }

}
