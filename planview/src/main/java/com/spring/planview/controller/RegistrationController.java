package com.spring.planview.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.planview.model.Roles;
import com.spring.planview.model.UserRegistration;
import com.spring.planview.service.RegistrationService;

@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;

	@RequestMapping(value="/register" , method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<UserRegistration> registerUser(@RequestBody UserRegistration user)
	{
		Set<Roles> roles = new HashSet<Roles>();
		Roles role = new Roles();
		role.setRole(Roles.ADMIN_ROLE);
		roles.add(role);
		user.setRoles(roles);
		return registrationService.saveUser(user);
	}
	
	
}
