package com.spring.planview.dao;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.spring.planview.model.Login;
import com.spring.planview.model.UserRegistration;

public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public ResponseEntity<Login> getUserByEmail(Login loginDetails) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from UserRegistration where email= :email");
	    query.setParameter("email", loginDetails.getEmail());
	    Object queryResult = query.uniqueResult();
	    UserRegistration user = (UserRegistration)queryResult;
		session.getTransaction().commit();
		session.close();
		if(user.getPassword().equals(loginDetails.getPassword())){
			return new ResponseEntity<Login>(HttpStatus.OK);
		}else{
			return new ResponseEntity<Login>(HttpStatus.CONFLICT);
		}
	}

}
