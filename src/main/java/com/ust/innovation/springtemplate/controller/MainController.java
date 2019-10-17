package com.ust.innovation.springtemplate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping("/testconnection")
	public String testConnection() {
		
		return "Connection OK";
	}

}
