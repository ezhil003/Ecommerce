package com.edison.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
    
	//@JsonIgnore
	@OneToMany //(mappedBy = "order")
	private List<OrderItem> orderItems;

//	@ManyToOne
//	@JoinColumn(name = "customer_id")
	private int userId;

	private double totalPrice;

	private LocalDate orderDate ;

	private String status;

	
	


}
