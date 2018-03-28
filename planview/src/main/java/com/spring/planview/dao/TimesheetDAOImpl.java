package com.spring.planview.dao;

import java.util.List;

import org.hibernate.Query;
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
	public List<Timesheet> saveTimesheet(Timesheet timesheetData) {
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(timesheetData);
		session.getTransaction().commit();
		session.close();
		List<Timesheet> timeSheetList = getTimeSheetList();
		return timeSheetList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timesheet> getTimeSheetList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Timesheet");
		List<Timesheet> list = query.list();
		return list;
	}

	@Override
	public ResponseEntity<Timesheet> updateTimeSheetDetails(Timesheet timesheetData) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.update(timesheetData);
		Timesheet timesheet = setTimeSheetUpdateDetails(timesheetData, session);
		session.merge(timesheet);
		session.getTransaction().commit();
		session.close();
		return new ResponseEntity<Timesheet>(HttpStatus.OK);
	}

	private Timesheet setTimeSheetUpdateDetails(Timesheet timesheetData, Session session) {
		Timesheet timesheet = (Timesheet) session.load(Timesheet.class, timesheetData.getId());
		timesheet.setDescription(timesheetData.getDescription());
		timesheet.setEmpId(timesheetData.getEmpId());
		timesheet.setName(timesheetData.getName());
		timesheet.setTic_Id(timesheetData.getTic_Id());
		timesheet.setTimelogged(timesheetData.getTimelogged());
		return timesheet;
	}

	@Override
	public ResponseEntity<Timesheet> deleteTimeSheetDetails(Timesheet timesheetData) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.update(timesheetData);
		Timesheet timesheet = deleteTimeSheetUpdateDetails(timesheetData, session);
		session.delete(timesheet);
		session.getTransaction().commit();
		session.close();
		return new ResponseEntity<Timesheet>(HttpStatus.OK);
	}
	private Timesheet deleteTimeSheetUpdateDetails(Timesheet timesheetData, Session session) {
		Timesheet timesheet = (Timesheet) session.load(Timesheet.class, timesheetData.getId());
		
		return timesheet;
	}
}
