package com.spring.planview.dao;

import org.springframework.http.ResponseEntity;

import com.spring.planview.model.Login;

public interface LoginDAO {

	public ResponseEntity<Login> getUserByEmail(Login loginDetails);

}
