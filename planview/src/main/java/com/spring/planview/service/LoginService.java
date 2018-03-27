package com.spring.planview.service;

import org.springframework.http.ResponseEntity;

import com.spring.planview.model.Login;

public interface LoginService {
	
	public ResponseEntity<Login> getUserByEmail(Login loginDetails);
	
	
}
