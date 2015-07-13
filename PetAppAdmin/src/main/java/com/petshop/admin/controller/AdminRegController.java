package com.petshop.admin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.bind.annotation.RestController;

import com.petshop.core.model.User;
import com.petshop.core.service.UserRegistrationService;


@RestController
public class AdminRegController {
	

	/*private static final Logger logger = Logger
			.getLogger(UserLoginController.class);*/

	@Autowired(required = true)
	UserRegistrationService userRegistrationService;

	/**
	 * This method will register or add's  the user details to DB
	  */
	@RequestMapping(value = "/addNewUser/{firstname}/{lastname}/{middlename}/{address}/{username}/{password}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public void userRegistration(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname,
			@PathVariable("middlename") String middlename,
			@PathVariable("address") String address,
			@PathVariable("username") String username,
			@PathVariable("password") String password) {
		//logger.info(" User Controller");

		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setMiddleName(middlename);
		user.setAddressLine1(address);
		user.setUserName(username);
		user.setPassword(password);
		user.setUserType("2");

		try {
			userRegistrationService.userRegistration(user);
		} catch (Exception e) {
			//logger.error("Exception on registration " + e);
		}

	}

}
