package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	// inject the file name from sport.properties
	@Value("${demoapp.fortunesFile}")
	private Resource fortunesFile;

	// ArrayList to store the fortunes
	ArrayList<String> theFortunes;
	// create a random number generator
	private Random myRandom = new Random();

	@PostConstruct
	public void loadTheFortunesFile() {
		System.out.println(">> FileFortuneService: inside the post construct life cycle method");
		theFortunes = new ArrayList<>();

		// while there is a fortune in the file, add it to fortunes ArrayList
		try (BufferedReader br = new BufferedReader(new InputStreamReader(fortunesFile.getInputStream()))) {
			while (br.ready()) {
				theFortunes.add(br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getDailyFortune() {
		// pick a random number between 0 to size of the fortunes ArrayList.
		// Notice that upper bound is excluded by default by nextInt()
		int index = myRandom.nextInt(theFortunes.size());

		// return the randomly picked fortune
		return theFortunes.get(index);
	}

}
