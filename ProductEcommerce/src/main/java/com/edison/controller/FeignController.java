package com.edison.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.edison.entity.Order;
import com.edison.feign.BackendFeign;
import com.edison.model.InventoryReport;
import com.edison.model.Product;
import com.edison.model.SalesReport;
import com.edison.service.InventoryService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
public class FeignController {

	private BackendFeign backendFeign;
	private InventoryService inventoryService;

	@Autowired
	public FeignController(BackendFeign backendFeign, InventoryService inventoryService) {
		super();
		this.backendFeign = backendFeign;
		this.inventoryService = inventoryService;
	}

//	public SalesReport generateSalesReport(String startDate, String endDate) {
//		LocalDate startdate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		LocalDate enddate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//		List<Order> orders = orderRepository.findByOrderDateBetween(startdate, enddate);
//		double totalSales = orders.stream().mapToDouble(order -> order.getTotalPrice()).sum();
//		return new SalesReport(startDate, endDate, totalSales);
//	}

	@GetMapping("/reports/inventory")
	@CircuitBreaker(name="inventory",fallbackMethod="fallbackGenerateInventoryReport")
	public InventoryReport generateInventoryReport() {
		return inventoryService.generateInventoryReport();
	}
	
	@GetMapping("/reports/sales")
	public SalesReport generateSalesReport(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return inventoryService.generateSalesReport(startDate, endDate);
	}
	
//	public InventoryReport generateReport(Exception e) {
//		return backendFeign.generateInventoryReport();
//	}
//	

//	
//	
//	
//	@PostMapping("/products")
//	public Product addProduct(@RequestBody Product product) {
//		return backendFeign.addProduct(product);
//	}
//	@PutMapping("/products/{productId}")
//	public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product) {
//		return backendFeign.updateProduct(productId, product);
//	}
//
//	@PutMapping("/products/{productId}/stock")
//	public Product updateProductStock(@PathVariable("productId") Long productId, @RequestParam("stock") int stock) {
//		return backendFeign.updateProductStock(productId, stock);
//	}
//	
//	@DeleteMapping("products/{productId}")
//	public void deleteProductById(@PathVariable("productId") Long productId) {
//		backendFeign.deleteProductById(productId);
//	}
	@GetMapping("/products/all")
	public List<Product> searchProducts() {
		return inventoryService.searchProducts();

	}
	@GetMapping("/view")
	public List<Product> view() {
		return inventoryService.view();

	}

//
//	@GetMapping("/products/{id}")
//	public Product getProductById(@PathVariable("id") Long id) {
//		return backendFeign.getProductById(id);
//	}

}
