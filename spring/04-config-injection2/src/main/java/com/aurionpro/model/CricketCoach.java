package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


public class CricketCoach implements ICoach{

	
	
	public CricketCoach() {
		super();
	}
	
	
	@Override
	public String getTrainingPlan() {
		return "Practice in net for 1.4 hours";
	}


}
