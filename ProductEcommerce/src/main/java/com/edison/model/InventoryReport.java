package com.edison.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class InventoryReport {
	




	public InventoryReport(String string) {
		// TODO Auto-generated constructor stub
	}

	private int totalProducts;

	private int totalStock;
	
	private List<Product> products;
	
	private String fallbackMessage;

}
