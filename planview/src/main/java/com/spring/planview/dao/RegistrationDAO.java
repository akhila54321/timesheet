package com.spring.planview.dao;

import com.spring.planview.model.UserRegistration;

public interface RegistrationDAO {
	public UserRegistration saveUser(UserRegistration registration);
}
