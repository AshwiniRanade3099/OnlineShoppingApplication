package com.sprint1.onlineshop.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.sprint1.onlineshop.dao.IProductRepository;
import com.sprint1.onlineshop.model.Product;

@Service
public class IProductServiceImpl implements IProductService{

	@Autowired
	IProductRepository productRepository;
	
	public List<Product> viewAllProducts(){
		List<Product> pList=productRepository.findAll();
    	return pList;
	}
	
	public Product viewProduct(int pid) {
		Product prd= productRepository.findById(pid).get();
		return prd;
		
	}
	 public Product addProduct(Product product) {
	    	return productRepository.save(product);
	    }
	 
	 public Product updateProduct(Product product) {
	    	return productRepository.save(product);
	    }
	 
	 public Product removeProduct(int pid){
		 Product prd=null;
		 if(productRepository.existsById(pid)) {
	    	prd= productRepository.findById(pid).get();
	    	productRepository.deleteById(pid);
	   		return prd;
	    		
	    	}
		 return prd;
	    	
	    	
		 
	 }
	
}
