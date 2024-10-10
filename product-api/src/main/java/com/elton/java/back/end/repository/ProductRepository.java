package com.elton.java.back.end.repository;

import com.elton.java.back.end.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "select p from Product p join p.category c where c.id = :categoryId")
    public List<Product> getProductByCategory(@Param("categoryId") long categoryId);    
    
    Product findByProductIdentifier(String productIdentifier);

}
