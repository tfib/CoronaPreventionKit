package com.eval.coronakit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.ProductMasterRepository;
import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductMasterRepository repository;

	@Override
	@Transactional
	public ProductMaster addNewProduct(ProductMaster product) throws CoronaException {
		if (product != null) {
			if (repository.existsById(product.getId())) {
				throw new CoronaException("Product Id is already exists");
			}

			if (repository.existsByProductName(product.getProductName())) {
				throw new CoronaException("Product Name is already exists");
			}
		}
		return repository.save(product);
	}

	@Override
	public List<ProductMaster> getAllProducts() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public ProductMaster deleteProduct(int productId) {
		ProductMaster product = repository.findById(productId).orElse(null);
		if (product != null) {
			repository.deleteById(productId);
			return product;
		}
		return null;
	}

	@Override
	public ProductMaster getProductById(int productId) {
		return repository.findById(productId).orElse(null);
	}

	@Override
	public Integer getCostById(int productId) {
		return repository.getCostById(productId);
	}

}
