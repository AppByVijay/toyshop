package com.tiwari.vijay.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class ToyShop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="toyid")
	private Integer id;
	
    @Column(name="name")
	private String toyname;
    
    @Column(name="price")
	private Double toyprice;
    
    @Column(name="category")
	private String category;
	
	
	

}
