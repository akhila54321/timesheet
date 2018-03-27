package com.spring.planview.service;

import org.springframework.http.ResponseEntity;

import com.spring.planview.model.Timesheet;

public interface TimesheetService {

	ResponseEntity<Timesheet> saveUser(Timesheet timesheetData);

}
