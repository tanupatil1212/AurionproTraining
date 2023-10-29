package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

@RestController
public class CoachController {
private ICoach coach2;
	
//	@Autowired
//	@Qualifier(value="cricketCoach")
	private ICoach coach1;
	
	public CoachController( @Qualifier(value="footBallCoach") ICoach coach2) {
		super();
		this.coach2=coach2;
	}
	
	@Autowired
	@Qualifier(value="cricketCoach")
	public void setICoach( ICoach coach1){
		this.coach1=coach1;
	}
	
	
	
	@GetMapping("/controller")
	public String showTrainingTable() {
//		System.out.println(coach1==coach2);
		System.out.println(coach1.getClass().getSimpleName()+":"+coach1.hashCode());
//		System.out.println(coach1.getTrainingPlan());
		System.out.println(coach2.getClass().getSimpleName()+":"+coach2.hashCode());
//		System.out.println(coach2.getTrainingPlan());
		return coach1.getTrainingPlan()+"<br> "+coach2.getDietPlain();
	}

}
