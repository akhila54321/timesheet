package com.spring.planview.controller;

import java.util.List;

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
	
	public @ResponseBody List<Timesheet> saveTimesheet(@RequestBody Timesheet timesheetData)
	{
		return timesheetService.saveTimesheet(timesheetData);
	}
	
	@RequestMapping(value="/timesheetList" , method=RequestMethod.GET,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Timesheet> getTimeSheetList() {
		return timesheetService.getTimeSheetList();
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<Timesheet> updateTimeSheetDetails(@RequestBody Timesheet timesheetData) {
		return timesheetService.updateTimeSheetDetails(timesheetData);
	}
	@RequestMapping(value="/delete" , method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<Timesheet> deleteTimeSheetDetails(@RequestBody Timesheet timesheetData) {
		return timesheetService.deleteTimeSheetDetails(timesheetData);
	}
}
