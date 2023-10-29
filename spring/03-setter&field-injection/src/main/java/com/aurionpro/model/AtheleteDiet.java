package com.aurionpro.model;

import org.springframework.stereotype.Component;

@Component
public class AtheleteDiet implements IDiet{

	@Override
	public String getPlan() {
		// TODO Auto-generated method stub
		return "This is athelete diet plan";
	}

}
