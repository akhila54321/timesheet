package com.spring.planview.service;

import org.springframework.http.ResponseEntity;

import com.spring.planview.model.UserRegistration;

public interface RegistrationService {
	
	public ResponseEntity<UserRegistration> saveUser(UserRegistration registration);

	UserRegistration getUserDetails(String email);

}
