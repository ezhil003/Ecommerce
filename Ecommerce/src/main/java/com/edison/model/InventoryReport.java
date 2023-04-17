package com.edison.model;

import java.util.List;

import com.edison.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryReport {

	private int totalProducts;

	private int totalStock;
	
	private List<Product> products;

}
