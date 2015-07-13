package com.petshop.admin.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

/*import com.petshop.core.controller.UserLoginController;*/
import com.petshop.core.model.User;
import com.petshop.core.service.UserLoginService;

@RestController
public class AdminLoginController {
	
	
	/*private static final Logger logger = Logger
			.getLogger(UserLoginController.class);
*/
	@Autowired(required = true)
	UserLoginService userLoginService;

	/**
	 * This method will check for user admin credentials
	 
	 */
	@RequestMapping(value = "/userLogin/{uname}/{password}", method = RequestMethod.GET, produces = {
			"application/xml", "application/json" })
	@ResponseBody
	public User checkUser(@PathVariable("uname") String uname,
			@PathVariable("password") String password) {
		System.out.println("uname is->>"+uname);
		System.out.println("password is->> "+password);
		//logger.info("checkUser");
		User user = new User();
		try {
			user = userLoginService.checkUser(uname, password);
		} catch (Exception e) {
			//logger.error("Exception" + e);
		}
		return user;

	}


}
