package com.edison.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesReport {
	

	private String startDate;

	private String endDate;

	private double totalSales;



}
