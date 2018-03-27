package com.spring.planview.dao;

import org.springframework.http.ResponseEntity;

import com.spring.planview.model.Timesheet;

public interface TimesheetDAO {

	ResponseEntity<Timesheet> saveUser(Timesheet timesheetData);

}
