package com.edison.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Cart;
import com.edison.entity.CartItem;
import com.edison.model.CartItemModel;
import com.edison.repo.CartItemRepo;
import com.edison.repo.CartRepository;

@Service
public class CartService {
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepo cartItemRepo;

//	@Autowired
//	private OrderService orderService;
	/**

	*Adds a new cart item to the user's cart or updates the total price of the cart after adding items.
	*@param Item The cart item to be added or updated.
	*@return A success message indicating that the items were added successfully.
	*/
	public String addItemToCart(CartItemModel Item) {
		Cart cart = cartRepository.findByUserId(Item.getUserId());
		List<CartItem> cartItems = cartItemRepo.findByCartId(cart.getId());
		cart.setCartItems(cartItems);
		Double total = (double) 0;
		for (CartItem citem : cartItems) {
			total += citem.getProduct().getPrice();
		}
		cart.setTotalPrice(total);
		cartRepository.save(cart);

		return "Added Items sucessfully";
	}

	/**

	*Retrieves all cart items belonging to a specific user from the cart repository.
	*@param userId The ID of the user whose cart items are to be retrieved.
	*@return A list of cart items belonging to the specified user.
	*/
	public List<CartItem> getallCartItems(int userId) {
		Cart cart = cartRepository.findByUserId(userId);
		List<CartItem> cartItems = new ArrayList<>();
		cartItems=cart.getCartItems();
		return cartItems;
	}

	/**

	*Proceeds to checkout for the given user by deleting the user's cart and its items.
	*@param userId The ID of the user whose cart will be checked out.
	*@return A string indicating the result of the checkout operation.
	*/
	public String proceedToCheckout(int userId) {
		Cart cart = cartRepository.findByUserId(userId);
		if (cart == null || cart.getCartItems() == null) {
			return "Cart is Empty";
		}
		cartRepository.deleteById(cart.getId());

		return "Cart Checkedout";
	}

	/**

	*Creates a new cart for a user with the given user ID.
	*@param userId The ID of the user for whom the cart is to be created.
	*/
	public void createCart(int userId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cartRepository.save(cart);

	}

}
