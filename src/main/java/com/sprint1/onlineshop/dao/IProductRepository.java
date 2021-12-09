package com.sprint1.onlineshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.onlineshop.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{

}
