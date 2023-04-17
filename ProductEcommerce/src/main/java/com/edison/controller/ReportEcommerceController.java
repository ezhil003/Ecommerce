package com.edison.controller;

//import com.edison.entity.Product;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

//import com.edison.model.InventoryReport;
//import com.edison.model.SalesReport;
//import com.edison.service.ReportService;

//@RestController
//public class ReportEcommerceController {
//	

//	@Autowired
//	private ReportService reportService;
//	
//	@GetMapping("/reports/sales")
//	public SalesReport generateSalesReport(
//			@RequestParam("startDate") String startDate,
//			@RequestParam("endDate") String endDate) {
//		return reportService.generateSalesReport(startDate, endDate);
//	}
//
//	@GetMapping("/reports/inventory")
//	public InventoryReport generateInventoryReport() {
//		return reportService.generateInventoryReport();
//	}
//}









// orderItem service implementation
//
//if(product.isPresent()){
//    int availableStock = product.get().getStock();
//    int requestedQuantity = order.getQuantity();
//    if(availableStock < requestedQuantity){
//        throw new IllegalArgumentException("Insufficient stock to fulfill the order");
//    }
//    int updatedStock = availableStock - requestedQuantity;
//    product.get().setStock(updatedStock);
//    productRepository.save(product.get());
//    orderItem.setProductId(product.get());
//    orderItem.setPrice(product.get().getPrice());
//}



// cartitem service implementation

//if(product.isPresent()) {
//    Product productObj = product.orElseThrow(); // Get the Product object
//    int currentQuantity = productObj.getStock(); // Get the current quantity
//    int newQuantity = currentQuantity - Item.getQuantity(); // Reduce the quantity
//    productObj.setStock(newQuantity); // Set the new quantity
//    cartItem.setProduct(productObj);
//}
