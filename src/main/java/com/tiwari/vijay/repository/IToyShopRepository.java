package com.tiwari.vijay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tiwari.vijay.entity.ToyShop;

public interface IToyShopRepository extends JpaRepository<ToyShop, Integer> {

	@Modifying
	@Query("UPDATE ToyShop SET toyprice=:price WHERE id=:id")
	void modifyPriceById(Double price, Integer id);

}
