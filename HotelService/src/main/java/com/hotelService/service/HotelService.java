package com.hotelService.service;

import java.util.List;

import com.hotelService.entities.Hotel;

public interface HotelService {
	
	//create
	Hotel create(Hotel hotel);
	
	//get all hotel
	List<Hotel> getAllHotel();
	
	//get single hotel
	Hotel getSingleHotel(String hotelId);
	
	//delete hotel
	void delete(String hotelId);
	
	//update hotel
	Hotel update(Hotel hotel, String hotelId);

}
