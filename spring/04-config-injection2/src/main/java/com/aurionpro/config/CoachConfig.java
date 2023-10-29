package com.aurionpro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aurionpro.model.CricketCoach;
import com.aurionpro.model.ICoach;

@Configuration
public class CoachConfig {
	
	@Bean
	public ICoach cricketCoach() {
		return new CricketCoach();
		
	}
	
}
