package com.tiwari.vijay.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiwari.vijay.entity.ToyShop;
import com.tiwari.vijay.exception.ToyNotFoundException;
import com.tiwari.vijay.service.IToyShopService;

@RestController
@RequestMapping("/rest/toy")
public class ToyShopRestController {
	
	@Autowired
	private IToyShopService service;
	
	
	//1. create toy
		@PostMapping("/create")
		public ResponseEntity<String> createToy(
				@RequestBody ToyShop toy) 
		{
			ResponseEntity<String> resp = null;
			try {
				Integer id = service.saveToy(toy);
				resp = new ResponseEntity<String>(
						"Toy '"+id+"' created",
						HttpStatus.CREATED);
			
			} catch (Exception e) {
			
				e.printStackTrace();
			}
			
			return resp;
		}
		
		//2. view all Toys
		@GetMapping("/all")
		public ResponseEntity<List<ToyShop>> getAllToys() {
			ResponseEntity<List<ToyShop>> resp = null;
			List<ToyShop> list = service.findAllToys();
			resp = new ResponseEntity<List<ToyShop>>(list, HttpStatus.OK);
			return resp;
		}
		
		//3. find one Toy by id
		@GetMapping("/find/{id}")
		public ResponseEntity<?> fetchOneToy(
				@PathVariable Integer id
				)
		{
			
			ResponseEntity<?> resp = null;
			try {
				ToyShop ts = service.findOneToy(id);
				resp = new ResponseEntity<ToyShop>(ts, HttpStatus.OK);
				
			} catch (ToyNotFoundException e) {
				
				e.printStackTrace();
				throw e;
			}
			
			return resp;
		}
		
		//4. delete one Toy
		@DeleteMapping("/remove/{id}")
		public ResponseEntity<String> removeOneToy(
				@PathVariable Integer id
				) 
		{
			ResponseEntity<String> resp = null;
			try {

				service.deleteToy(id);
				resp = new ResponseEntity<String>(id+"-deleted!", HttpStatus.OK);
				
			} catch (ToyNotFoundException e) {
				e.printStackTrace();
				throw e;
				/*resp = new ResponseEntity<String>(
						e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);*/
			}
			return resp;
		}
		
		//5. update one Toy
		@PutMapping("/modify")
		public ResponseEntity<String> updateToy(
				@RequestBody ToyShop toy) 
		{
			ResponseEntity<String> resp = null;
			try {
				service.updateToy(toy);
				resp = new ResponseEntity<String>(
						"Toy updated!", 
						//HttpStatus.RESET_CONTENT (205)
						HttpStatus.OK
						);
			} catch (ToyNotFoundException e) {
				e.printStackTrace();
				throw e;
			}
			return resp;
		}
		
		//6. partial update (Toy price)
		@PatchMapping("/update/{id}/{price}")
		public ResponseEntity<String> updateToyPrice(
				@PathVariable Integer id,
				@PathVariable Double price
				) 
		{
			ResponseEntity<String> resp = null;
			try {
				service.modifyPriceById(price, id);
				resp = new ResponseEntity<String>(
						"Toy Price Updated",
						//HttpStatus.PARTIAL_CONTENT (206)
						HttpStatus.OK
						);
			} catch (ToyNotFoundException e) {
				e.printStackTrace();
				throw e;
			}
			return resp;
		}

}
