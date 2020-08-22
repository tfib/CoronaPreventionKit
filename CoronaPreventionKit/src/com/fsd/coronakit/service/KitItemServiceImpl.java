package com.fsd.coronakit.service;

import java.util.ArrayList;
import java.util.List;

import com.fsd.coronakit.entity.KitItem;
import com.fsd.coronakit.entity.Product;
import com.fsd.coronakit.exception.CoronaException;

public class KitItemServiceImpl implements KitItemService {

	@Override
	public KitItem addItemToKit(Product product) throws CoronaException {
		KitItem kitItem = new KitItem();
		try {
			kitItem.setProduct(product);
			kitItem.setPrice(0.0);
			kitItem.setQuantity(0);
		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return kitItem;
	}

	@Override
	public KitItem updatePrice(KitItem item, int quantity) throws CoronaException {
		try {
			if (!(item.getProduct() == null)) {
				item.setQuantity(quantity);
				item.setPrice((item.getProduct().getPcost()) * (item.getQuantity()));
			}
		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return item;

	}

	@Override
	public double getTotalPrice(List<KitItem> kitItems) throws CoronaException {
		double totalPrice = 0.0;
		try {
			if (!(kitItems.isEmpty() || kitItems == null)) {
				for (KitItem item : kitItems) {
					totalPrice += item.getPrice();
				}
			}

		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return totalPrice;
	}

}
