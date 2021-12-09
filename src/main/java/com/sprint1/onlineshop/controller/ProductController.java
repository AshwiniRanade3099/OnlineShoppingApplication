package com.sprint1.onlineshop.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.onlineshop.exception.ErrorInfo;
import com.sprint1.onlineshop.exception.ProductException;
import com.sprint1.onlineshop.model.Product;
import com.sprint1.onlineshop.service.IProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	IProductServiceImpl service;
	
	@GetMapping("/viewAllProducts")
    public List<Product> viewAllProducts(){
    	
    	List<Product> pList=service.viewAllProducts();
    	return pList;
    	
    	
    }
	
    @GetMapping("/viewProduct/{pid}")
    
    public Product viewProduct(@PathVariable("pid") int pid) {
    
    
    	Product p=service.viewProduct(pid);
    	return p;
    	
    }
    
    @PostMapping("/addProduct")
    
    public Product addProduct(@RequestBody Product p) {
    	return service.addProduct(p);
    }
    
    
    @PutMapping("/updateProduct")

    public Product updateProduct(@RequestBody Product p) {
    	return service.updateProduct(p);
    }

    
    @DeleteMapping("/deleteProduct/{id}")
    
    public ResponseEntity<Product> removeProduct(@PathVariable("id") int pid) throws ProductException{
    	Product prd=service.removeProduct(pid);
    	if(prd!=null)
    	
    	  	return new ResponseEntity<Product>(prd, HttpStatus.OK);
    		
    	
    	else
    		
    		return new ResponseEntity<Product>(prd, HttpStatus.NOT_FOUND);
    	
    	
    }
    
    @ExceptionHandler(ProductException.class)
    public @ResponseBody ErrorInfo getExeptionHandler(Exception e, HttpServletRequest req) {
		
		  return new ErrorInfo(LocalDateTime.now(), e.getMessage(),req.getRequestURI());
		  
		
	}
}
