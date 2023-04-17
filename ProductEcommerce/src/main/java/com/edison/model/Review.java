package com.edison.model;

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
public class Review {
//	@Id 
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String comment;

	private int rating;
	private int userId;
	
	//@ManyToOne
	private Product prodId;

}
