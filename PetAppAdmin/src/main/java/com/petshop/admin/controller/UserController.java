package com.petshop.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.User;
import com.petshop.core.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/userAdmin", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public List<User> UserDetails(){
		System.out.println("inside user controller");
		
		List<User>userdetails=null;
		try{
			System.out.println("fetching userdetails");
			userdetails=userService.getUserDatails();
			System.out.println("UserDetails"+userdetails);
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		return userdetails;
		
		
		
	}

}
