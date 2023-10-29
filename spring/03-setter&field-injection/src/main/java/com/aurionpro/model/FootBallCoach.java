package com.aurionpro.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Scope("prototype")
public class FootBallCoach implements ICoach{

private IDiet diet;
	
	public FootBallCoach(@Qualifier(value="atheleteDiet") IDiet diet) {
		super();
		this.diet = diet;
	}
	@Override
	public String getTrainingPlan() {
		return "Practice on penalty for 1 hours";
	}

	
	public String getDietPlain() {
		System.out.println("Inside Cricket diet plan");
		System.out.println(diet.getPlan());
		return diet.getPlan();
	}

}
