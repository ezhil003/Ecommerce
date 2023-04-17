
package com.edison.entity;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
//@ApiModel(value = "Model class for User.")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

//	@ApiModelProperty(value = "userId of the User.")
	//@OneToMany(mappedBy = "Cart")
	private int userId;

//	@ApiModelProperty(value = "userName of the User.")
	@Column(unique = true)
	private String userName;
	private String address;
	private Long number;
//	@ApiModelProperty(value = "emailId of the User.")
	@Column(unique = true)
	private String emailId;
//	@ApiModelProperty(value = "password of the User.")
	private String password;
//	@OneToMany(mappedBy = "user")
//	private List<Cart> carts;
	

}