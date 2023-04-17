package com.edison.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edison.entity.Cart;
import com.edison.entity.OrderItem;
import com.edison.model.OrderModel;

@Service
public interface OrderItemService {
	
	OrderItem setOrderItem(OrderModel order);
	List<OrderItem> setOrderItems(Cart cart);

}
