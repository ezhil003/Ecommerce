package com.edison.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.Product;


public interface ProductRepository extends JpaRepository<Product,Long> {
	List<Product> findByCategoryAndSubcategory(String category, String subcategory);
	List<Product> findByNameContainingIgnoreCase(String keyword);
	Product findByNameAndDescription(String name, String description);
}
