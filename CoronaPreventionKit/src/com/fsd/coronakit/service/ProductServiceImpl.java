package com.fsd.coronakit.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsd.coronakit.dao.ProductDaoImpl;
import com.fsd.coronakit.entity.Product;
import com.fsd.coronakit.exception.CoronaException;

public class ProductServiceImpl implements ProductService {

	ProductDaoImpl productDao;

	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	private boolean isValidProductId(int productId) {
		return (productId > 0);
	}

	private boolean isValidProductName(String productName) {
		return productName.matches("^.*[a-zA-Z0-9].*$");
	}

	private boolean isValidProductPrice(double price) {
		return price > 0.0d;
	}

	private boolean isValidDescription(String productDescription) {
		return productDescription.matches("^.*[a-zA-Z0-9].*$");
	}

	private boolean isValidProduct(Product p) throws CoronaException {
		boolean isValid = true;
		List<String> errorMessages = new ArrayList<>();
		if (p != null) {
			if (!isValidProductId(p.getProductId())) {
				errorMessages.add("Product Id should be greater than zero");
			}
			if (!isValidProductName(p.getpName())) {
				errorMessages.add("Product Name should contain only alphabets and numbers");
			}
			if (!isValidProductPrice(p.getPcost())) {
				errorMessages.add("Product Cost should be greater than zero");
			}
			if (!isValidDescription(p.getpDescription())) {
				errorMessages.add("Product Description should contain only alphabets and numbers");
			}
			if (!errorMessages.isEmpty()) {
				throw new CoronaException("Incorrect Values: " + errorMessages);
			}
		} else {
			isValid = false;
			throw new CoronaException("Product Details are not Provided");
		}

		return isValid;
	}

	@Override
	public int validateAndAddProduct(Product p) throws CoronaException {
		int productAdded = 0;
		if (isValidProduct(p)) {
			productAdded = productDao.addProduct(p);
		}
		return productAdded;
	}

	@Override
	public Product validateAndGetProduct(int productId) throws CoronaException {
		return productDao.getProduct(productId);
	}

	@Override
	public List<Product> getAllProducts() throws CoronaException {
		return productDao.getAllProducts();
	}

	@Override
	public int validateAndDeleteProduct(int productId) throws CoronaException {
		return productDao.deleteProduct(productId);
	}

	@Override
	public int validateAndUpdate(Product product) throws CoronaException {
		int productUpdated = 0;
		if (isValidProduct(product)) {
			productUpdated = productDao.updateProduct(product);
		}
		return productUpdated;
	}

}
