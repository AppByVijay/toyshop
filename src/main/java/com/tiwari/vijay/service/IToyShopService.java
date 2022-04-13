package com.tiwari.vijay.service;

import java.util.List;

import com.tiwari.vijay.entity.ToyShop;

public interface IToyShopService {
	
	Integer saveToy(ToyShop ts);
	ToyShop findOneToy(Integer id);
	List<ToyShop> findAllToys();
	void deleteToy(Integer id);
	void updateToy(ToyShop ts);
	void modifyPriceById(Double price,Integer id);

}
