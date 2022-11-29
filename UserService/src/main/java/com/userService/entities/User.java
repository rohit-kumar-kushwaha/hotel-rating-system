package com.userService.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.userService.db.models.Rating;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "hrs_user")
public class User {
	
	@Id
	@Column(name = "ID")
	private String userId;
	private String name;
	private String email;
	private String about;
	private String phoneNo;
	
	@Transient
	private List<Rating> rating = new ArrayList<>();
	

}
