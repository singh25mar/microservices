package com.lcwd.user.service.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.Exception.UserNotFoundException;
import com.lcwd.user.service.Repository.UserRepository;
import com.lcwd.user.service.entity.Hotel;
import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.services.UserServices;
@Service
public class UserServiceImpl implements UserServices{
	@Autowired
	private UserRepository repo;
	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		String uid = UUID.randomUUID().toString();
		user.setUserId(uid);
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public List<User> getAllUSer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		User user = repo.findById(userId).orElseThrow(()-> new UserNotFoundException("OOPS USer Not found") );
		Rating[]ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), Rating[].class);
		// appling rest template to get data from rating api
		logger.info("{}",ratingsOfUser);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating ->{
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotles/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			logger.info("response status code: {} ",forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		
		user.setRatings(ratingList);
		return user;
		
	}

	/*
	 * @Override public User getUser(String userId) { // TODO Auto-generated method
	 * stub return repo.findById(userId).orElseThrow(()-> new
	 * UserNotFoundException("OOPs USer NOt Found"));
	 */
		 
	

}
