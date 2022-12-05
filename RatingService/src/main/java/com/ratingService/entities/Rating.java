package com.ratingService.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hrs_rating")
public class Rating {
	
	@Id
	@Column(name = "ID")
	private String ratingId;
	private String userId;
	private String hotelId;
	private String rating;
	private String feedback;

}
