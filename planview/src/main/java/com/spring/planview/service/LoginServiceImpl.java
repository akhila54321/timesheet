package com.spring.planview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.spring.planview.dao.LoginDAO;
import com.spring.planview.model.Login;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDAO;

	@Override
	public ResponseEntity<Login> getUserByEmail(Login loginDetails) {
		return loginDAO.getUserByEmail(loginDetails);
	}
	
	
}
