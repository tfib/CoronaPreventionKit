package com.eval.coronakit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository repository;

	@Override
	public KitDetail addKitItem(KitDetail kitItem) {
		if (kitItem != null)
			return repository.save(kitItem);
		else {
			System.out.println("kitItem is blank");
			return null;
		}
	}

	@Override
	public KitDetail getKitItemById(int itemId) {
		return repository.findById(itemId).orElse(null);
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) {
		return repository.findAll();
	}

}
