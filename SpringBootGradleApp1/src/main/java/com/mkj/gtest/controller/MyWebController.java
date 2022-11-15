package com.mkj.gtest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkj.gtest.dto.MyDTO;
import com.mkj.gtest.dto.UserDefaultResponseDTO;
import com.mkj.gtest.entity.AppUser;
import com.mkj.gtest.service.AppUserService;
import com.mkj.gtest.util.UserDTOConvertor;

@RestController
@RequestMapping("/facebook")
public class MyWebController {

	@Autowired
	AppUserService userService;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	public MyWebController() {
		System.out.println("\n\n\n====>> Inside Constructor "+this);
	}

	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody AppUser user) 
	{
		/*
		 * // request body annotation  , help u 
		 * to take user information as JSON , so it convert JSON object to AppIser Object
		 * */
		try {
			AppUser savedUser =  userService.insertUser(user);
			String responseMsg = savedUser.getUsername()+" save with Id "+savedUser.getUserId();
			
			
			mylogs.info(" ---->> Inside App User Constroller Post mapping , user created "+responseMsg);
			return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg =  "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			mylogs.error(errorMsg);
			return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

	@GetMapping("/welcome")
	public String abc()
	{
		return "Welcome to Facebook";
	}
	
	
	
	// http://localhost:8001/facebook/userandrole/ramesh
		@GetMapping("/roles/{role}")
		public List<AppUser> abc(@PathVariable String role)throws Exception
		{
			System.out.println(" --->> 1 Inside controller "+role);
			return userService.getUsersByRole(role);
		}
	
	
		@GetMapping("/usersbyId")
		public List<AppUser> usersById(@RequestParam int r1 , @RequestParam int r2)throws Exception
		{
			
			return userService.getUsersBetweenIds(r1, r2);
		}	
	
		@GetMapping("/validate/{searchUsername}")
		public String abc3(@PathVariable String searchUsername)throws Exception
		{
			AppUser user =  userService.getUserByUserName(searchUsername);
			if(user != null) return user.getUsername();
			else return null;
		}
	
	
	// http://localhost:8001/facebook/userandrole/ramesh
	@GetMapping("/user/{searchUsername}")
	public AppUser abc2(@PathVariable String searchUsername)throws Exception
	{
		return userService.getUserByUserName(searchUsername);
	}
	
	// http://localhost:8001/facebook/userandrole/ramesh?role=user
	@GetMapping("/userandrole/{searchUsername}")
	public AppUser abc3(@PathVariable String searchUsername,@RequestParam String role)throws Exception
	{
		if(role != null)
		{
			return userService.getUserByUserNameAndRole(searchUsername,role);
		}
		else return null;
		
	}
	
	
	
	
	
	@GetMapping("/users")
	public List<AppUser> getAllUsers()
	{
		// write some code to extract users
		try {
			List<AppUser>  allExtractedUsers = userService.getAllUsers();
			
			return allExtractedUsers;
			
		} catch (Exception e) {
			// code missing for expection handling 
			System.out.println(e);
			
		}
		
		return null;
	}
	
	
	
	@PutMapping("/user/hobbies")
	public AppUser updateHobbies(@RequestBody List<String> allHobbies,@RequestParam String username)
	{
		
		System.out.println(" \n\n ======= Inside Web Controller add hobbies =====\n\n");
		System.out.println("1.  allHobbies :-  "+allHobbies);
		System.out.println(" username :-  "+username);
		
		
		
		AppUser savedUser = null; 
		try {
			 savedUser = userService.getUserByUserName(username);
			if(savedUser != null)
			{
				AppUser updatedUser = userService.addHobbies(allHobbies, savedUser);
				return updatedUser;
			}
			else
			{
				throw new Exception("User not found "+savedUser+" for "+username);
			}
			
		} catch (Exception e) {
			System.out.println(savedUser+" is not");
		}
		
		
		return null;
	}
	
	
	@GetMapping("/user/id/{id}")
	public ResponseEntity<MyDTO> getUserByUserId(@PathVariable int id)throws Exception
	{
		
			AppUser user = userService.getUserById(id);
			
			UserDefaultResponseDTO dtoResp = UserDTOConvertor.getUserDefaultDTO(user);
			
			return new ResponseEntity<MyDTO>(dtoResp, HttpStatus.OK);
		
	}
	
	
}




















