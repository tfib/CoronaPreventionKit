package com.fsd.coronakit.service;

import java.util.List;

import com.fsd.coronakit.entity.KitItem;
import com.fsd.coronakit.entity.Product;
import com.fsd.coronakit.exception.CoronaException;

public interface KitItemService {

	public KitItem addItemToKit(Product product) throws CoronaException;

	public KitItem updatePrice(KitItem item, int quantity) throws CoronaException;

	public double getTotalPrice(List<KitItem> kitItems) throws CoronaException;

}
