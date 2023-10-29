package com.aurionpro.controlller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class TestController {

	@GetMapping("/test1")
	public String showGreeting() {
		return "Inside Hello COntroller";
	}

}
