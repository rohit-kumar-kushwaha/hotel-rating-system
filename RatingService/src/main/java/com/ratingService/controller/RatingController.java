package com.ratingService.controller;

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

import com.ratingService.constants.RatingConstants;
import com.ratingService.entities.Rating;
import com.ratingService.service.RatingService;

@RestController
@RequestMapping(value = RatingConstants.RATINGS)
public class RatingController {

	@Autowired
	private RatingService ratingService;

	// create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		Rating createRating = ratingService.create(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
	}

	// get all rating
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings() {
		List<Rating> ratings = ratingService.getRatings();
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}

	// get all by userId
	@GetMapping(value = RatingConstants.RATINGBYUSERID)
	public ResponseEntity<List<Rating>> getRatingbyUserId(@PathVariable String userId) {
		List<Rating> ratingsByUserId = ratingService.getRatingsByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(ratingsByUserId);
	}

	// get all by hotelId
	@GetMapping(value = RatingConstants.RATINGBYHOTELID)
	public ResponseEntity<List<Rating>> getRatingbyHotelId(@PathVariable String hotelId) {
		List<Rating> ratingsByHotelId = ratingService.getRatingByHotelId(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(ratingsByHotelId);
	}
}
