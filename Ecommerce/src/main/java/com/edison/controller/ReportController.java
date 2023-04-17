package com.edison.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edison.entity.Order;
import com.edison.model.InventoryReport;
import com.edison.model.SalesReport;
import com.edison.service.OrderService;
import com.edison.service.ReportService;

@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;
	
//	@GetMapping("/reports/sales")
//	public SalesReport generateSalesReport(
//			@RequestParam("startDate") String startDate,
//			@RequestParam("endDate") String endDate) {
//		return reportService.generateSalesReport(startDate, endDate);
//	}

//	@GetMapping("/reports/inventory")
//	public InventoryReport generateInventoryReport() {
//		return reportService.generateInventoryReport();
//	}
	@GetMapping("/reports/sales")
	public List<Order> generateOrderReport(
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return reportService.generateOrder(startDate, endDate);
	}
}
