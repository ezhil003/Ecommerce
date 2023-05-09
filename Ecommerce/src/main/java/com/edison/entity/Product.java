package com.edison.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity



public class Product implements Serializable {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String description;

	private String category;

	private String subcategory;

	private int stock;

	private double price;
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<CartItem> cartItems;
	
    @JsonIgnore
	@OneToMany(mappedBy = "productId")
	private List<OrderItem> orderItems;

//	//@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER)//(mappedBy = "prodId")
	@JoinColumn(name="pId",referencedColumnName = "id")
	private List<Review> reviews; 
    
//    @OneToMany(mappedBy = "prodId",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<Review> reviews =new ArrayList<>();



}