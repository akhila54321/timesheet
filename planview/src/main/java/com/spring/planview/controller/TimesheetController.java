package com.spring.planview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.planview.model.Timesheet;
import com.spring.planview.service.TimesheetService;

@Controller
public class TimesheetController {
	
	@Autowired
	TimesheetService timesheetService;

	@RequestMapping(value="/timesheet" , method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<Timesheet> registerUser(@RequestBody Timesheet timesheetData)
	{
		return timesheetService.saveUser(timesheetData);
	}
}
