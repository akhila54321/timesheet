package com.spring.planview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.planview.dao.TimesheetDAO;
import com.spring.planview.model.Timesheet;


@Service
@Transactional
public class TimesheetServiceImpl implements TimesheetService{
	
	@Autowired
	TimesheetDAO timesheetDao;

	@Override
	public ResponseEntity<Timesheet> saveUser(Timesheet timesheetData) {
		return timesheetDao.saveUser(timesheetData);
	}

}
