package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entity.Hotel;

public interface HotelServices{
	
	// Create User
	
	public Hotel create(Hotel hotel);
	
	// get All Hotel
	
	
	List <Hotel> getAll();
	
	
	// get Hotel By id 
	
	public Hotel gethotelByid(String id);

}
