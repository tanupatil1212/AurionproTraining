package com.aurionpro.model;

import org.springframework.stereotype.Component;

@Component
public class AthletDiet implements IDiet {

	@Override
	public String getPlan() {
		return "This is athelete diet plan";
	}

}
