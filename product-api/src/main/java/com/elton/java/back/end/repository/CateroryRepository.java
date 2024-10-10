package com.elton.java.back.end.repository;

import com.elton.java.back.end.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CateroryRepository extends JpaRepository<Category, Long> {

}
