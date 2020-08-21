package com.fsd.coronakit.service;

import java.util.List;

import com.fsd.coronakit.entity.Product;
import com.fsd.coronakit.exception.CoronaException;

public interface ProductService {
	
	public int validateAndAddProduct(Product p) throws CoronaException;

	public Product validateAndGetProduct(int productId) throws CoronaException;

	public List<Product> getAllProducts() throws CoronaException;

	public int validateAndDeleteProduct(int productId) throws CoronaException;
	
	public int validateAndUpdate(Product product) throws CoronaException;

}
