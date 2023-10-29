package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class CricketCoach implements ICoach{

	private IDiet diet;
	public CricketCoach(@Qualifier(value="weightLossDiet")IDiet diet) {
		  super();
		  this.diet = diet;
		 }
	@Override
	public String getTrainingPlan() {
	    return "Practice penalty in  2 hrs";
	}
	 public String getDietPlan() {
		//  System.out.println("Inside Cricket diet plan");
		//  System.out.println(diet.getPlan());
		  return diet.getPlan();
		 }


}
