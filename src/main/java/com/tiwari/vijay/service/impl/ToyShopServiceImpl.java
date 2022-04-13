package com.tiwari.vijay.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiwari.vijay.entity.ToyShop;
import com.tiwari.vijay.exception.ToyNotFoundException;
import com.tiwari.vijay.repository.IToyShopRepository;
import com.tiwari.vijay.service.IToyShopService;

@Service
public class ToyShopServiceImpl implements IToyShopService {
	
	@Autowired
	private IToyShopRepository repo;

	
	public Integer saveToy(ToyShop ts) {
		return repo.save(ts).getId();
	}

	
	public ToyShop findOneToy(Integer id) {
		return repo.findById(id).orElseThrow(
				()->new ToyNotFoundException(id + "- not found"));
	}

	
	public List<ToyShop> findAllToys() {
		return repo.findAll();
	}

	
	public void deleteToy(Integer id) {
		 repo.delete(findOneToy(id));

	}

	
	public void updateToy(ToyShop ts) {
		if(null==ts.getId() || !repo.existsById(ts.getId())) {
			throw new ToyNotFoundException(ts.getId()+ " - not found");
		} else {
			repo.save(ts);
		}

	}

	@Transactional
	public void modifyPriceById(Double price, Integer id) {
		if(!repo.existsById(id))
			throw new ToyNotFoundException(id+ " - not found");
		repo.modifyPriceById(price, id);

	}

}
