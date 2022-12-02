package com.hotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelService.constants.HotelConstants;
import com.hotelService.entities.Hotel;
import com.hotelService.exceptions.ResourceNotFoundException;
import com.hotelService.repository.HotelRepository;
import com.hotelService.service.HotelService;
import com.hotelService.service.impl.HotelServiceImpl;

@RestController
@RequestMapping(value = HotelConstants.HOTELS)
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	//create hotel
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
		Hotel savedHotel = hotelService.create(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
	}
	
	//get all hotel
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> allHotel = hotelService.getAllHotel();
		return ResponseEntity.status(HttpStatus.OK).body(allHotel);
	}
	
	// get one hotel
	@GetMapping(value = HotelConstants.HOTELID)
	public ResponseEntity<Hotel> getOneHotel(@PathVariable String hotelId) {
		Hotel hotel = hotelService.getSingleHotel(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	// delete hotel
	@DeleteMapping(value = HotelConstants.HOTELID)
	public void delete(@PathVariable String hotelId) {
		try {
			hotelService.delete(hotelId);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Hotel not found for deleting.");
		}
	}
	
	// update hotel detail
	@PutMapping(value = HotelConstants.HOTELID)
	public ResponseEntity<Hotel> update(@RequestBody Hotel hotel, @PathVariable String hotelId) {
		Hotel updatedHotel = hotelService.update(hotel, hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(updatedHotel);
	}

}
