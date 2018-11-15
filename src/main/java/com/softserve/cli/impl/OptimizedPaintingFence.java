package com.softserve.cli.impl;

import java.util.Scanner;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

public class OptimizedPaintingFence extends AbstractCLI implements CommandLineInterface{
	
	private int numberOfColors;
    private int numberOfPosts;

	public OptimizedPaintingFence(Scanner prompt) {
		super(prompt);
	}

	@Override
	public void run() {
		System.out.printf("%s\n%s\n", algorithmOption.getOptionName(),
                algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptNParamethers, INVALID_NUMBER_MSG);
        InvalidInputHandler.promptIfInvalidValue(this::promptKParamethers, INVALID_NUMBER_MSG);
        System.out.println("The MAX number of possible ways of painting the fence is " + Algorithms.findingMaxWaysOfPaintingTheFence(numberOfPosts, numberOfColors));
	}
	
	private boolean promptNParamethers() {
        System.out.print("Please enter number of colors (it has to be more than 0): ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.numberOfPosts = InputUtil.readIntValue(prompt);
        return this.numberOfPosts>=1;
    }

    private boolean promptKParamethers() {
        System.out.print("Please enter number of posts (it has to be more than 0): ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.numberOfColors = InputUtil.readIntValue(prompt);
        return this.numberOfColors >= 1;
    }

}
