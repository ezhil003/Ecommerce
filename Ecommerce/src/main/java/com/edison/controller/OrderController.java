package com.edison.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edison.entity.Order;
import com.edison.model.OrderModel;
import com.edison.service.OrderService;

@RestController
@CrossOrigin("http://localhost:3001")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
//	private UserDetailsServiceImpl userdetails;

	@GetMapping("/orders/history/{userId}")
	public List<Order> getOrderHistory(@PathVariable("userId")int userId) {
		return orderService.getOrderHistory(userId);
	}

	@GetMapping("/orders/{orderId}")
	public String getOrderStatus(@PathVariable("orderId") Long orderId) {
		return orderService.getOrderStatus(orderId);
	}

	@PostMapping("/order/cart")
	public String createBulkOrder(@RequestParam Long cartId) {
	return orderService.createBulkOrder(cartId);
	}
	
	@PostMapping("/order/product")
	public String createOrder(@RequestBody OrderModel order) {
		return orderService.createOrder(order);
	}
	
}
