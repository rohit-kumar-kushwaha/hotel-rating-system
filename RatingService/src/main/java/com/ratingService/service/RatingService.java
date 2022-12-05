package com.ratingService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ratingService.entities.Rating;


public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	// get all ratings
	List<Rating> getRatings();
	
	//get all rating by userId
	List<Rating> getRatingsByUserId(String userId);
	
	//get all ratings by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	

}
