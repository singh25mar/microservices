package com.lcwd.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.services.HotelServices;

@RestController
@RequestMapping("/hotles")
public class HotelController {
	@Autowired
	private HotelServices hotelServices;
	
	
	// create 
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelServices.create(hotel));
		
	}
	
	// get all
	@GetMapping
	public ResponseEntity<List<Hotel>> getall(){
		return ResponseEntity.ok(hotelServices.getAll());
	}
	
	// get single
	@GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId){
		
		return ResponseEntity.status(HttpStatus.OK).body(hotelServices.gethotelByid(hotelId));
		
	}

}
