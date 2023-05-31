package com.fpoly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fpoly.model.Product;
import java.util.List;


public interface ProductDAO extends JpaRepository<Product, Integer>{
    @Query("SELECT p FROM Product p WHERE p.category.Id=:id")
    List<Product> findByCategoryById(@Param("id") Integer id);
    
    List<Product> findByNameLike(String name);
}