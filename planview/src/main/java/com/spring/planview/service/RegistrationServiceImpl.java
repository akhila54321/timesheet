package com.spring.planview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.planview.dao.RegistrationDAO;
import com.spring.planview.model.UserRegistration;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationDAO registrationDao;

	@Override
	public UserRegistration saveUser(UserRegistration registration) {
		return registrationDao.saveUser(registration);
	}

}
