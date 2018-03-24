package com.spring.planview.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.planview.model.UserRegistration;
import com.spring.planview.service.RegistrationService;



@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	
	
/*	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
*/


	@RequestMapping(value="/Register" , method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody UserRegistration registerUser(@RequestBody UserRegistration user)
	{
		
		  /*Session session = sessionFactory.openSession();
		   session.beginTransaction();
		  UserRegistration s = new UserRegistration();
		  s.setEmloyeeemail(p.getEmail());
		  s.setPassword(p.getpassword());
		  session.save(s);
		  session.getTransaction().commit();
		 session.close();*/
		    
		return registrationService.saveUser(user);
	}
	
	
}
