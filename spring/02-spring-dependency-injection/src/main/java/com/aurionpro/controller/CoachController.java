package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.model.ICoach;

@RestController
public class CoachController {
	
	private ICoach coach1;
	private ICoach coach2;

//	public CoachController( ICoach coach1,  ICoach coach2) {
//	    super();
//	    this.coach1 = coach1;
//	    this.coach2 = coach2;
//	}

	public CoachController(@Qualifier(value="cricketCoach")ICoach coach1, @Qualifier(value="footballCoach")ICoach coach2) {
		  super();
		  this.coach1 = coach1;
		  this.coach2 = coach2;
		 }
	@GetMapping("/test")
	public String showTrainingTable() {
//		System.out.println(coach1==coach2);
//		System.out.println(coach1.hashCode());
//		System.out.println(coach2.hashCode());
//		System.out.println(coach1.getTrainingPlan());
//		System.out.println(coach2.getTrainingPlan());
//		return coach1.getTrainingPlan();
//		System.out.println(coach1.getDietPlan());
		  return coach2.getDietPlan();
	}
//	@Qualifier("cricketCoach")
//	@Qualifier("footballCoach")
}
