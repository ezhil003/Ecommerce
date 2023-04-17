package com.edison.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
	
	private int userId;
	
    private String productName;
	
	private int quantity;
	
	private double price;
	
	private Long productId;
	
	private Long orderId; 

	private Double totalPrice;

	private String status;

	private String date;
}
