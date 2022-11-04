package com.mkj.gtest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FBUsers")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	
	private String username;
	private String password;
	private String role;  // admin , tech-user , customer , corporates 
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profile")
	private Profile userProfile;
	
	@ElementCollection
	@CollectionTable(name = "FBUser_Hobbies")
	private List<String> hobbies;
	
	
	public AppUser(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	
	
	
	
	
}
