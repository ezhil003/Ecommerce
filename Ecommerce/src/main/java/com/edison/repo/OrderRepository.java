package com.edison.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edison.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	// double totalSales = orders.stream().mapToDouble(order ->
	// order.getTotalAmount()).sum();

	List<Order> findByUserId(int userId);

	List<Order> findByOrderDateBetween(LocalDate startDate, LocalDate endDate);

	// List<Order> findByOrderDateBetween(String startDate, String endDate);

}
