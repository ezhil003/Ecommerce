package com.edison.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edison.entity.Order;
import com.edison.entity.Product;
import com.edison.entity.Review;
import com.edison.model.ReviewModel;

import jakarta.transaction.Transactional;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	List<Review> findById(long prodId);
	List<Review> findByUserId(int userId);
	//List<Review> findById(Product productId);
	Review findById(int id);

	@Query (value="SELECT r FROM Review r WHERE r.pId=?1",nativeQuery = true )
	List<Review> findByProdId(Long productId);



}
