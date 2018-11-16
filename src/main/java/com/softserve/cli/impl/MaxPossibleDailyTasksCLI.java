package com.softserve.cli.impl;

import java.util.Scanner;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.ArrayUtil;
import com.softserve.cli.util.InputUtil;

public class MaxPossibleDailyTasksCLI extends AbstractCLI implements CommandLineInterface {

	private int high[];
	private int low[];
	private int n;

	public MaxPossibleDailyTasksCLI(Scanner prompt) {
		super(prompt);
	}

	@Override
	public void run() {
		System.out.printf("%s\n%s\n", algorithmOption.getOptionName(), algorithmOption.getOptionDescription());
		InvalidInputHandler.promptIfInvalidValue(this::promptNParamethers, INVALID_NUMBER_MSG);
		InvalidInputHandler.promptIfInvalidValue(this::promptHighSequence, BAD_SEQUENCE_FORMAT_MSG);
		InvalidInputHandler.promptIfInvalidValue(this::promptLowSequence, BAD_SEQUENCE_FORMAT_MSG);
		int result = Algorithms.findindMaxSumOfPossibleDailyTasks(high, low, n);
		System.out.println("This is your optimal quantity of tasks - " + result);
	}

	private boolean promptNParamethers() {
		System.out.print("Please enter the number of days you have the(only positive integer numbers): ");
		if (!InputUtil.hasNextInt(prompt))
			return false;
		this.n = InputUtil.readIntValue(prompt);
		return (this.n >= 1);
	}

	private boolean promptHighSequence() {
		System.out.print("Enter the first pull of tasks for all days you've chosen, NOT MORE, NOT LESS DAYZZ: ");
		String sequence = prompt.nextLine();
		this.high = ArrayUtil.parseIntegerSequence(sequence);
		
		if(this.checkIfArrHasNegativeValues(this.high) == false) {
			return false;
		}

		return (this.high.length == this.n);
	}

	private boolean promptLowSequence() {
		System.out.print("Enter the second pull of tasks for all days you've chosen, NOT MORE, NOT LESS DAYZZ: ");
		String sequence = prompt.nextLine();
		this.low = ArrayUtil.parseIntegerSequence(sequence);
		
		if(this.checkIfArrHasNegativeValues(this.low) == false) {
			return false;
		}
		
		return (this.low.length == this.n);
	}

	private boolean checkIfArrHasNegativeValues(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				System.out.println("There is negative value in your array, try one more time");
				return false;
			}
		}
		return true;
	}
}
