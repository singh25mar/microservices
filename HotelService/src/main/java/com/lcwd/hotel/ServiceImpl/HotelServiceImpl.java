package com.lcwd.hotel.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.Exception.ResourceNotFound;
import com.lcwd.hotel.Reposatory.HotelRepo;
import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.services.HotelServices;
@Service
public class HotelServiceImpl implements HotelServices {
	@Autowired
	private HotelRepo repo;
	
	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String HotelId = UUID.randomUUID().toString();
		hotel.setId(HotelId);
		return this.repo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Hotel gethotelByid(String id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).orElseThrow(()->new ResourceNotFound("Hotel Id not Found !!!!!!"));
	}

}
