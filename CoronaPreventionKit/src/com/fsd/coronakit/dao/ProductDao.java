package com.fsd.coronakit.dao;

import java.util.List;

import com.fsd.coronakit.entity.Product;
import com.fsd.coronakit.exception.CoronaException;

public interface ProductDao {

	public int addProduct(Product p) throws CoronaException;

	public Product getProduct(int productId) throws CoronaException;

	public List<Product> getAllProducts() throws CoronaException;

	public int deleteProduct(int productId) throws CoronaException;

	public int updateProduct(Product p) throws CoronaException;

}
