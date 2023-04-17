package com.edison.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edison.entity.Product;
import com.edison.repo.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	
    //private final ReviewRepository  reviewRepository;
	private final ProductRepository productRepository;
	/**

	*Adds a new product to the system or updates an existing product's stock.
	*@param product The product to be added or updated.
	*@return The added or updated product.
	*/
	public Product addProduct(Product product) {
		Product prod= productRepository.findByNameAndDescription(product.getName(), product.getDescription());
		if(prod!=null) {
			prod.setStock(prod.getStock()+product.getStock());
			return productRepository.save(prod);
		}
		else {
			return productRepository.save(product);
		}
		
	}

	/**

	*Retrieves a list of products from the repository based on the provided category and subcategory.
	*@param category The category of the products to be retrieved.
	*@param subcategory The subcategory of the products to be retrieved.
	*@return A list of products matching the provided category and subcategory.
	*/
	public List<Product> getProductsByCategoryAndSubcategory(String category, String subcategory) {
		return productRepository.findByCategoryAndSubcategory(category, subcategory);
	}
	
	
	/**

	*Searches for products in the repository based on a provided keyword.
	*@param keyword The keyword to be used for searching products.
	*@return A list of products that contain the provided keyword in their name (case-insensitive).
	*/
	public List<Product> searchProducts(String keyword) {
		return productRepository.findByNameContainingIgnoreCase(keyword);
	}
	
	/**

	*Retrieves all products from the repository, returning a list of all available products.
	*@return A list of all products in the system.
	*/
	public List<Product> searchProducts() {
		return productRepository.findAll();
	}
    
	/**

	*Retrieves a product from the repository based on the provided product ID.
	*@param id The ID of the product to be retrieved.
	*@return The product with the matching ID, or throws an exception if not found.
	*@throws NoSuchElementException if the product with the given ID is not found in the repository.
	*/
    public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow();
	}
    /**

    *Updates an existing product in the system with the provided product information.
    *@param productId The ID of the product to be updated.
    *@param product The product information to update the existing product.
    *@return The updated product.
    */
	public Product updateProduct(Long productId, Product product) {
		Product existingProduct = getProductById(productId);
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setSubcategory(product.getSubcategory());
		existingProduct.setStock(product.getStock());
		return productRepository.save(existingProduct);
	}
	/**

	*Updates the stock of an existing product in the system.
	*@param productId The ID of the product to be updated.
	*@param stock The new stock value to be set for the product.
	*@return The updated product with the new stock value.
	*/
	public Product updateProductStock(Long productId, int stock) {
		Product existingProduct = getProductById(productId);
		existingProduct.setStock(stock);
		return productRepository.save(existingProduct);
	}
	/**

	*Deletes a product from the system based on the provided product ID.
	*@param productId The ID of the product to be deleted.
	*/
	public void deleteProduct (Long productId) {
		productRepository.deleteById(productId);
	}

}