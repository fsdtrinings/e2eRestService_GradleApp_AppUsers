package com.mkj.gtest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;import org.hibernate.validator.internal.constraintvalidators.bv.notempty.NotEmptyValidatorForArraysOfLong;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mkj.gtest.entity.AppUser;
import com.mkj.gtest.repository.AppUserRepository;

@SpringBootTest
class AppUserServiceImplTest {

	@Mock
	AppUserRepository appUserRepository;
	
	@InjectMocks
	AppUserServiceImpl appuserService;
	
	
	
	@Test
	@DisplayName("Test - to verify the insert operation")
	//@Disabled
	void testInsertUser() throws Exception {
		// given
		AppUser sampleInput = new AppUser("A","A", "user");
		AppUser expectedOutput = new AppUser("A","A", "user");
		//Object obj = new Object();
		BDDMockito.given(appuserService.insertUser(sampleInput)).willReturn(expectedOutput);
		
		// when 
		AppUser actualOutput = appuserService.insertUser(sampleInput);
		
		// verify 
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	@Disabled
	void testGetAllPosts() {
		fail("Not yet implemented");
	}

	@Test
	//@Disabled
	@DisplayName("Test to verify the method getUser by Id should return AppUser or not")
	void testGetUserById() throws Exception 
	{
		
		// give 
		AppUser sampleOutput = new AppUser("A","A", "user");
		sampleOutput.setUserId(1);
		
		int sampleInput = 1;
		
		BDDMockito.given(appuserService.getUserById(sampleInput)).willReturn(sampleOutput);
		
		// when 
		AppUser actualOutput = appuserService.getUserById(sampleInput);
		
		// verify
		assertEquals(sampleOutput,actualOutput);
		assertSame(sampleOutput.getUserId(), actualOutput.getUserId());
		assertThat(actualOutput.getUserId()).isGreaterThan(0);
		
	}
	

	@Test
	//@Disabled
	@DisplayName(" Test to check users between Id")
	void testGetUsersBetweenIds() throws Exception {
		
		// give 
		
		AppUser user1 = new AppUser("A","A", "user");
		user1.setAllPosts(null);
		user1.setHobbies(null);
		user1.setUserProfile(null);
		
		AppUser user2 = new AppUser("B","B", "user");
		user1.setAllPosts(null);
		user1.setHobbies(null);
		user1.setUserProfile(null);
		
		
		List<AppUser> sampleOutput = new ArrayList<>();
		sampleOutput.add(user1);
		sampleOutput.add(user2);
		
		int sampleInput1 = 1;
		int sampleInput2 = 20;
		
		
		BDDMockito.given(appuserService.getUsersBetweenIds(sampleInput1, sampleInput2))
		          .willReturn(sampleOutput);
		
		
		// when 
		
		List<AppUser> actualOutput = appuserService.getUsersBetweenIds(sampleInput1, sampleInput2);
		
		
		// verify 
		assertEquals(sampleOutput, actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
		assertNotNull(actualOutput);
	
	}

	@Test
	@Disabled
	void testGetUsersByRole() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("Test to verify all user returend")
	//@Disabled
	void testGetAllUsers() throws Exception {
	
		// given
		
		AppUser user1 = new AppUser("A","A", "user");
		user1.setAllPosts(null);
		user1.setHobbies(null);
		user1.setUserProfile(null);
		
		AppUser user2 = new AppUser("B","B", "user");
		user1.setAllPosts(null);
		user1.setHobbies(null);
		user1.setUserProfile(null);
		
		
		List<AppUser> sampleOutput = new ArrayList<>();
		sampleOutput.add(user1);
		sampleOutput.add(user2);
		
		BDDMockito.given(appuserService.getAllUsers()).willReturn(sampleOutput);
		
		// ----------------------------------------------------------------------
		
		// when :- readyto test the funcationality (service)
		List<AppUser> actualOutput = appuserService.getAllUsers();
		
		
		// then : verify the sampleOutput with actual output
		// assertThat(actualOutput).isNotNull();  // or
		assertNotNull(actualOutput);
		assertThat(actualOutput.size()).isGreaterThan(0);
		assertIterableEquals(sampleOutput, actualOutput);
		
	}

	
}


























