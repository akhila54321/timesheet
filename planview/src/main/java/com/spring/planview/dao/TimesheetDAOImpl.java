package com.spring.planview.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.spring.planview.model.Timesheet;

@Repository
public class TimesheetDAOImpl implements TimesheetDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public ResponseEntity<Timesheet> saveUser(Timesheet timesheetData) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Integer saved = (Integer) session.save(timesheetData);
		session.getTransaction().commit();
		session.close();
		
		if(saved == 1)
			return new ResponseEntity<Timesheet>(HttpStatus.OK);
		else
			return new ResponseEntity<Timesheet>(HttpStatus.CONFLICT);
	}

}
