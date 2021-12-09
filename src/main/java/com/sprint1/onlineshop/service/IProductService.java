package com.sprint1.onlineshop.service;

import java.util.List;

import com.sprint1.onlineshop.model.Product;

public interface IProductService {

	public List<Product> viewAllProducts();
	
	public Product viewProduct(int pid);
	
	public Product addProduct(Product product);
	
	public Product removeProduct(int pid);
	
	public Product updateProduct(Product product);
}
