package com.edison.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem{

	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	@JsonIgnore
	//@ManyToOne
	private Cart cart;
   
	//@ManyToOne
	private Product product;


}
