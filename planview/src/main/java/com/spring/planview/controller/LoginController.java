package com.spring.planview.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.planview.model.Login;
import com.spring.planview.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

/*	@RequestMapping(value="/signin" , method=RequestMethod.GET,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	public UserRegistration  getUserByEmail(@RequestParam("email") String email){
		return loginService.getUserByEmail(email);
	}*/
	
	@RequestMapping(value="/signin" , method=RequestMethod.POST,consumes={MediaType.APPLICATION_JSON_VALUE},produces={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Login>  getUserByEmail(@RequestBody String loginDetails) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		Login login = mapper.readValue(loginDetails, Login.class);
		return loginService.getUserByEmail(login);
	}
	

	@RequestMapping(value="/index" , method=RequestMethod.GET)
	public String  login(){
		
	 return "forward:/pages/index.html";
	}
}
