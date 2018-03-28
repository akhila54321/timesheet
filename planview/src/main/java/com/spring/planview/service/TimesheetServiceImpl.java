package com.spring.planview.service;

import java.util.List;

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
	public List<Timesheet> saveTimesheet(Timesheet timesheetData) {
		return timesheetDao.saveTimesheet(timesheetData);
	}


	@Override
	public List<Timesheet> getTimeSheetList() {
		return timesheetDao.getTimeSheetList();
	}


	@Override
	public ResponseEntity<Timesheet> updateTimeSheetDetails(Timesheet timesheetData) {
		return timesheetDao.updateTimeSheetDetails(timesheetData);
	}


	@Override
	public ResponseEntity<Timesheet> deleteTimeSheetDetails(Timesheet timesheetData) {
		// TODO Auto-generated method stub
		return timesheetDao.deleteTimeSheetDetails(timesheetData);
	}

}
