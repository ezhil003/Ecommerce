package com.edison.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edison.entity.Cart;
import com.edison.entity.CartItem;
import com.edison.entity.Product;
import com.edison.model.CartItemModel;
import com.edison.repo.CartItemRepo;
import com.edison.repo.CartRepository;
import com.edison.repo.ProductRepository;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartItemRepo cartItemRepo;
	
	@Autowired
	ProductRepository productRepository;

//	public void AddCartItem(CartItemModel Item) {
//		CartItem cartItem =new CartItem();
//		Cart cart = cartRepository.findByUserId(Item.getUserId());
//		if(cart!=null) {
//			cartItem.setCart(cart);
//			
//		}else {
//			Cart cartt = new Cart();
//			cartt.setUserId(Item.getUserId());
//			cartRepository.save(cartt);
//			cartItem.setCart(cartt);
//		}
//		Optional<Product> product = productRepository.findById(Item.getProductId());
//		if(product.isPresent())
//			cartItem.setProduct(product.get());
//	
//		cartItem.setQuantity(Item.getQuantity());
//		cartItemRepo.save(cartItem);
//		
//	}
	

	/**

	*Adds a new cart item to the user's cart or updates the quantity of an existing cart item.
	*@param Item The cart item to be added or updated.
	*/
	public void AddCartItem(CartItemModel Item) {
	    Cart cart = cartRepository.findByUserId(Item.getUserId());
	    CartItem cartItem = null;

	    if (cart != null) {
	        // Check if the cart already contains the product
	        for (CartItem itemInCart : cart.getCartItems()) {
	            if (itemInCart.getProduct().getId().equals(Item.getProductId())) {
	                // Increase the quantity of the existing cart item
	                cartItem = itemInCart;
	                cartItem.setQuantity(cartItem.getQuantity() + Item.getQuantity());
	                break;
	            }
	        }
	    }

	    if (cartItem == null) {
	        // Create a new cart item if the product is not already in the cart
	        cartItem = new CartItem();
	        Optional<Product> product = productRepository.findById(Item.getProductId());
	        if (product.isPresent()) {
	            cartItem.setProduct(product.get());
	        }
	        cartItem.setQuantity(Item.getQuantity());
	    }

	    if (cart == null) {
	        // Create a new cart if one doesn't exist for the user
	        cart = new Cart();
	        cart.setUserId(Item.getUserId());
	        cartRepository.save(cart);
	    }

	    cartItem.setCart(cart);
	    cartItemRepo.save(cartItem);
	}


}
