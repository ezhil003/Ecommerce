package com.edison.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.edison.feign.BackendFeign;
import com.edison.model.InventoryReport;
import com.edison.model.Order;
import com.edison.model.Product;
import com.edison.model.SalesReport;
import com.edison.repository.InventoryRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;
	@Autowired
	private BackendFeign report;
	/**

	*Generates an inventory report by retrieving product data from a remote service using a circuit breaker pattern.
	*If the remote service fails or encounters an error, the fallbackMethod "generateInventoryReportFallback" will be invoked.
	*@return An inventory report containing total products, total stock, and a list of products.
	*/
    @CircuitBreaker(name="generateInventoryReport",fallbackMethod = "generateInventoryReportFallback")
	public InventoryReport generateInventoryReport() {
		List<Product> products = report.searchProducts();
		int totalProducts = products.size();
		int totalStock = 0;
		for (Product product : products) {
			totalStock += product.getStock();
		}
		return new InventoryReport(totalProducts, totalStock, products, null);
	}
    /**

    *Fallback method for generating an inventory report. This method is called when the remote service fails or encounters an error.
    *It retrieves product data from a local repository as a fallback.
    *@param T The Throwable object representing the error or exception that occurred in the remote service.
    *@return An inventory report containing total products, total stock, and a list of products retrieved from the local repository.
    */
	public InventoryReport generateInventoryReportFallback(Throwable T) {
//		List<Product> products = inventoryRepo.findAll();
//		int totalProducts = products.size();
//		int totalStock = 0;
//		for (Product product : products) {
//			totalStock += product.getStock();
//		}
		return new InventoryReport(0, 0,null, "Service Unavailable");
	}

	/**

	*Generates a sales report for a given date range.
	*@param startDate The start date of the sales report in "yyyy-MM-dd" format.
	*@param endDate The end date of the sales report in "yyyy-MM-dd" format.
	*@return A SalesReport object containing the start date, end date, and total sales for the given date range.
	*/
	public SalesReport generateSalesReport(String startDate, String endDate) {
		LocalDate startdate = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		LocalDate enddate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String startDateString = startdate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String endDateString = enddate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		List<Order> orders = report.generateOrderReport(startDateString, endDateString);
		double totalSales = orders.stream().mapToDouble(order -> order.getTotalPrice()).sum();
		return new SalesReport(startDate, endDate, totalSales);
	}
	@CircuitBreaker(name="searchProducts",fallbackMethod = "searchProductsFallback")
	public List<Product> searchProducts() {
		return report.searchProducts();

	}
	
	public List<Product> searchProductsFallback(Throwable T) {
		return inventoryRepo.findAll();

	}
	
	public List<Product> view() {
		return inventoryRepo.findAll();

	}


}
