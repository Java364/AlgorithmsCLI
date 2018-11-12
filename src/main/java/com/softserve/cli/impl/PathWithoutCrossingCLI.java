package com.softserve.cli.impl;

import java.util.Scanner;

import com.softserve.algorithms.PathWithoutCrossing;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

public class PathWithoutCrossingCLI extends AbstractCLI implements CommandLineInterface{
	
	private int numberPoints = 0;
	
	public PathWithoutCrossingCLI(Scanner prompt) {
		 super(prompt);
	}

	@Override
	public void run() {
		 System.out.printf("%s\n%s\n", algorithmOption.getOptionName(),
                 algorithmOption.getOptionDescription());
		 InvalidInputHandler.promptIfInvalidValue(this::promptPathWithoutCrossing, INVALID_NUMBER_MSG);
		 int result = new PathWithoutCrossing().pathsWithoutCrossing(numberPoints);
		 System.out.format("We can connect %d points without crossing such ways: "
		 		+ " %d\n", numberPoints, result);
	}
	
	private boolean promptPathWithoutCrossing() {
		 System.out.print("Please enter the number of points- n which is integer, where n is even: ");
	        if (!InputUtil.hasNextInt(prompt))
	            return false;
	        this.numberPoints = InputUtil.readIntValue(prompt);
	        return this.numberPoints >= 1;
	}

}
