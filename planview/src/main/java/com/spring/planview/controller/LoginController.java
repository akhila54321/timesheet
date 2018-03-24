package com.spring.planview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.planview.model.UserRegistration;
import com.spring.planview.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value="/signin" , method=RequestMethod.GET,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public UserRegistration  getUserByEmail(@RequestParam("email") String email){
		return loginService.getUserByEmail(email);
	}
	
	

	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String  login(){
		
	 return "redirect:/login.html";
	}
}
