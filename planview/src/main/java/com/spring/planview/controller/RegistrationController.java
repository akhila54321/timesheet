package com.spring.planview.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {
	
	@RequestMapping(value="/" , method=RequestMethod.GET,produces={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Map<String,String> getmessage()
	{
		Map<String,String> map = new HashMap<String,String>();
		map.put("id", "123");
		map.put("name", "Akhila");
		return map;
	}
}
