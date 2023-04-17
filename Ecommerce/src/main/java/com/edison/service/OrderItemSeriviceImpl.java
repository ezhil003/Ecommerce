package com.edison.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Cart;
import com.edison.entity.CartItem;
import com.edison.entity.Order;
import com.edison.entity.OrderItem;
import com.edison.entity.Product;
import com.edison.model.OrderModel;
import com.edison.repo.OrderItemRepository;
import com.edison.repo.ProductRepository;
@Service
public class OrderItemSeriviceImpl implements OrderItemService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	/**

	*Creates a new order item based on the provided order details, including updating the product stock and calculating the total price.
	*@param order The order details, including product ID, quantity, and user ID.
	*@return The created order item.
	*@throws IllegalArgumentException If the requested quantity exceeds the available stock of the product.
	*/
	public OrderItem setOrderItem(OrderModel order) {
	    OrderItem orderItem = new OrderItem();
	    //Product product1=new Product();
	    Product product = productRepository.findById(order.getProductId()).orElse(null);
	    if (product!=null) {
	        int requestedQuantity = order.getQuantity();
	        int availableStock = product.getStock();
	        if (requestedQuantity > availableStock) {
	            throw new IllegalArgumentException("Insufficient stock to fulfill the order");
	        }
	        int updatedStock = availableStock - requestedQuantity;
	        product.setStock(updatedStock);
	        orderItem.setProductId(product);
	        orderItem.setPrice(product.getPrice());
	        orderItem.setQuantity(requestedQuantity);
	        orderItem.setUserId(order.getUserId());
	        orderItemRepository.save(orderItem);
	        double totalPrice = requestedQuantity * product.getPrice();
	        orderItem.setPrice(totalPrice);
	    }
	    return orderItem;
	}





//	public List<OrderItem> setOrderItems(Cart cart) {
//		List<OrderItem> items = new ArrayList<OrderItem>();
//		for (CartItem cartItem : cart.getCartItems()) {
//	        OrderItem orderItem = new OrderItem();
//	        orderItem.setProductId(cartItem.getProduct());
//	        orderItem.setQuantity(cartItem.getQuantity());
//	        orderItem.setPrice(cartItem.getProduct().getPrice());
//	        orderItem.setUserId(cart.getUserId());
//	        orderItemRepository.save(orderItem);
//	        items.add(orderItem);
//	    }
//	    return items;
//		}
	
	
	/**

	*Sets order items for the given cart by creating order items based on the cart items.
	*Updates the product stock, calculates total price for each order item, and saves them to the order item repository.
	*@param cart The cart for which order items need to be created.
	*@return A list of order items created from the cart items.
	*@throws IllegalArgumentException If requested quantity exceeds available stock for any cart item.
	*/
	public List<OrderItem> setOrderItems(Cart cart) {
	    List<OrderItem> items = new ArrayList<OrderItem>();
	    for (CartItem cartItem : cart.getCartItems()) {
	        OrderItem orderItem = new OrderItem();
	        Product product = cartItem.getProduct();
	        int requestedQuantity = cartItem.getQuantity();
	        int availableStock = product.getStock();
	        if (requestedQuantity > availableStock) {
	            throw new IllegalArgumentException("Insufficient stock to fulfill the order");
	        }
	        int updatedStock = availableStock - requestedQuantity;
	        product.setStock(updatedStock);
	        productRepository.save(product);
	        orderItem.setProductId(product);
	        orderItem.setQuantity(requestedQuantity);
	        double totalPrice = requestedQuantity * product.getPrice();
	        orderItem.setPrice(totalPrice);
	        
	        orderItem.setUserId(cart.getUserId());
	        orderItemRepository.save(orderItem);
	        items.add(orderItem);
	    }
	    return items;
	}


}
