package com.edison.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnRequest {



	@Enumerated(EnumType.STRING)
	private ReturnRequestStatus status;

	

	// getters and setters
}



