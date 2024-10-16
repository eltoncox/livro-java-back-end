package com.elton.java.back.end.service;

import com.elton.java.back.end.converter.DTOConverter;
import com.elton.java.back.end.model.Product;
import com.elton.java.back.end.model.dto.ProductDTO;
import com.elton.java.back.end.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId( Long categoryId) {

        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public ResponseEntity<ProductDTO> findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ResponseEntity.ok(DTOConverter.convert(product));
        }
        return ResponseEntity.notFound().build(); // Retorna 404 Not Found
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }

    public ProductDTO delete(long ProductId) {
        Optional<Product> Product = productRepository.findById(ProductId);
        if(Product.isPresent()) {
            productRepository.delete(Product.get());
        }
        return null;
    }
}
