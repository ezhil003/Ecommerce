package com.edison.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Refund {

	

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "customer_id")
//	private Customer customer;

	@Enumerated(EnumType.STRING)
	private RefundStatus status;

}
