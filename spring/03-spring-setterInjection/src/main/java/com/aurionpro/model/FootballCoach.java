package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class FootballCoach implements ICoach{

	 private IDiet diet;

	 public FootballCoach(@Qualifier(value="athletDiet")IDiet diet) {
	  super();
	  this.diet = diet;
	 }
	public String getTrainingPlan() {
	    return "Practice in the net for 2 hrs";
	}
	
	 @Override
	 public String getDietPlan() {
	//  System.out.println("Inside football diet plan");
	//  System.out.println(diet.getPlan());
	  return diet.getPlan();
	 }
}
