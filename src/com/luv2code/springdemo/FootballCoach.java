package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Work on your freekick";
	}
	
	public String getDailyFortune() {
		return "Hello best of luck";
	}

}
