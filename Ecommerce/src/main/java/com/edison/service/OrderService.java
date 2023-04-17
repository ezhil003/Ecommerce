package com.edison.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;

import com.edison.entity.Cart;
import com.edison.entity.Order;
import com.edison.entity.OrderItem;
import com.edison.model.OrderModel;
import com.edison.model.OrderStatus;
import com.edison.repo.CartRepository;
import com.edison.repo.OrderItemRepository;
//import com.edison.model.SalesReport;
//import com.edison.repo.CustomerRepository;
import com.edison.repo.OrderRepository;
import com.edison.repo.ProductRepository;
//import com.edison.repo.ReportRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Autowired
	private ProductRepository productRepository;
//	@Autowired 
//	private CustomerRepository customerRepository;


//	@Autowired
//	private CustomerRepository customerRepository;
//	@Autowired
//	private ReportRepository reportRepository;
//	@Autowired
//	private ReportService reportService;


	/**

	*Retrieves the order history for a given user based on the provided user ID.
	*@param userId The ID of the user for whom the order history is to be retrieved.
	*@return A list of orders associated with the user ID.
	*/
	public List<Order> getOrderHistory(int userId) {
		List<Order> orders = orderRepository.findByUserId(userId);
		return orders;
	}
	
	/**

	*Retrieves the status of an order based on the provided order ID.
	*@param orderId The ID of the order whose status is to be retrieved.
	*@return The status of the order.
	*@throws NoSuchElementException If no order is found with the provided order ID.
	*/
	public String getOrderStatus(Long orderId) {
		 Order order = orderRepository.findById(orderId).orElseThrow();
		 return order.getStatus();
	}
	
	/**

	*Creates a new order with the provided order details, including order items.
	*@param Item The order details, including order items, to be created.
	*@return A string indicating that the order has been created.
	*/
	public String createOrder(OrderModel Item ) {
		Order order = new Order();
		order.setUserId(Item.getUserId());
        OrderItem orderItem = orderItemService.setOrderItem(Item) ;
		List<OrderItem> items = new ArrayList<>();

		items.add(orderItem);
		order.setOrderItems(items);
		order.setTotalPrice(orderItem.getPrice());
		order.setOrderDate(LocalDate.now());
		order.setStatus(OrderStatus.PROCESSING.toString());
		orderRepository.save(order);
		return "order created";
	}


	
	/**

	*Creates a bulk order from the items in the specified cart.
	*@param CartId The ID of the cart from which to create the order.
	*@return A status message indicating that the order has been created.
	*/


	public String createBulkOrder(Long CartId) {
		Order order = new Order();
	
		Optional<Cart> cart = cartRepository.findById(CartId);
		List<OrderItem> orderItems = orderItemService.setOrderItems(cart.get());
		order.setOrderItems(orderItems);
		order.setOrderDate(LocalDate.now());
		double total = 0;
		for(OrderItem orditem : orderItems) {
			total+=orditem.getPrice();
			
		}
		order.setTotalPrice(total);
		order.setUserId(cart.get().getUserId());
		order.setStatus(OrderStatus.PROCESSING.toString());
		orderRepository.save(order);
		return "order created";
	}

}
