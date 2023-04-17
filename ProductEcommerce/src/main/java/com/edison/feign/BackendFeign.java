package com.edison.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;


import com.edison.model.InventoryReport;
import com.edison.model.Order;
import com.edison.model.Product;

//import com.edison.controller.InventoryReport;
//import com.edison.controller.SalesReport;


//@FeignClient(name="backendFeign",url="localhost:9876/")
@FeignClient(name="ECOMMERCE",path="/")
public interface BackendFeign {
	@GetMapping("/reports/sales")
	public List<Order> generateOrderReport(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate);

	@GetMapping("/reports/inventory")
	public InventoryReport generateInventoryReport();
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product);
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable("id") Long id);
	@GetMapping("/products/all")
	public List<Product> searchProducts();
	@PutMapping("/products/{productId}/stock")
	public Product updateProductStock(@PathVariable("productId") Long productId, @RequestParam("stock") int stock);
	@PutMapping("/products/{productId}")
	public Product updateProduct(@PathVariable("productId") Long productId, @RequestBody Product product);
	@DeleteMapping("products/{productId}")
	public void deleteProductById(@PathVariable("productId") Long productId);

}
