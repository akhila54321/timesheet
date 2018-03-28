package com.spring.planview.dao;

import org.springframework.http.ResponseEntity;

import com.spring.planview.model.UserRegistration;

public interface RegistrationDAO {
	 ResponseEntity<UserRegistration> saveUser(UserRegistration registration);

	 UserRegistration getUserDetails(String email);
}
