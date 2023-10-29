package com.aurionpro.controlller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${name}")
	private String name;
	@Value("${degree}")
	private String degree;
	
	
	@GetMapping("/test")
	public String showGreeting() {
		return "Inside Hello COntroller"+" "+name+" "+degree;
	}

}
