package com.edison.service;

import org.springframework.stereotype.Service;

import com.edison.model.CartItemModel;

@Service
public interface CartItemService {

	void AddCartItem(CartItemModel cartItem);

}
