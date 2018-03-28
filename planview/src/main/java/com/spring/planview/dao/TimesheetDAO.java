package com.spring.planview.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.spring.planview.model.Timesheet;

public interface TimesheetDAO {

	List<Timesheet> saveTimesheet(Timesheet timesheetData);
	List<Timesheet> getTimeSheetList();
	ResponseEntity<Timesheet> updateTimeSheetDetails(Timesheet timesheetData);
	ResponseEntity<Timesheet> deleteTimeSheetDetails(Timesheet timesheetData);
}
