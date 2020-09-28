package com.eval.coronakit.service;

import java.util.List;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;

public interface ProductService {

	public ProductMaster addNewProduct(ProductMaster product) throws CoronaException;
	public List<ProductMaster> getAllProducts();
	public ProductMaster deleteProduct(int productId);
	public ProductMaster getProductById(int productId);
	public Integer getCostById(int productId);
}
