package com.mkj.gtest.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mkj.gtest.dto.UserDefaultResponseDTO;
import com.mkj.gtest.dto.UserPostCreatedResponseDTO;
import com.mkj.gtest.entity.AppUser;
import com.mkj.gtest.entity.Post;

@Component
@Scope("singleton")
public class UserDTOConvertor {

	public static UserDefaultResponseDTO  getUserDefaultDTO(AppUser user)
	{
		UserDefaultResponseDTO dto = new UserDefaultResponseDTO(
				                 user.getUsername(), 
				                 user.getUserId(), 
				                 user.getUserProfile().getEmail(),
				                 "User Profile Created , Profile Id : "+user.getUserProfile().getProfileId());
		
		return dto;
	}
	
	
	
	
	public static UserPostCreatedResponseDTO getPostCreatedDTO(AppUser user,Post post)
	{
		UserPostCreatedResponseDTO dto = new UserPostCreatedResponseDTO(
				 user.getUsername(), 
                 user.getUserId(), 
                 post.getDescription(),
                 "Post Added "+post.getDate()
                 );
				 
				 return dto;
	}
}
