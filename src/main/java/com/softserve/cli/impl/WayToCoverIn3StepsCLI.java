package com.softserve.cli.impl;

import java.util.Scanner;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

public class WayToCoverIn3StepsCLI extends AbstractCLI implements CommandLineInterface {

	private int distance;

	public WayToCoverIn3StepsCLI(Scanner prompt) {
		super(prompt);
	}

	@Override
	public void run() {
		System.out.printf("%s\n%s\n", algorithmOption.getOptionName(), algorithmOption.getOptionDescription());
		InvalidInputHandler.promptIfInvalidValue(this::promptDistance, INVALID_NUMBER_MSG);
		int countOfWays = Algorithms.waysToCoverIn3StepsAlgorithm(distance);
		System.out.printf("There are %d ways to cover %d \n ", countOfWays, distance);
	}

	private boolean promptDistance() {
		if (!InputUtil.hasNextInt(prompt)) {
			return false;
		}
		distance = InputUtil.readIntValue(prompt);
		return distance >= 2;
	}
}
