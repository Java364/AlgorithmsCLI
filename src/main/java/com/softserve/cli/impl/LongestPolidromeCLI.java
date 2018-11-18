package com.softserve.cli.impl;

import java.util.Scanner;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;

public class LongestPolidromeCLI extends AbstractCLI implements CommandLineInterface {
	protected static final String EMPTY_STRING_MSG = "I cant find a polidrome in empty string";
	private String line;
	public LongestPolidromeCLI(Scanner prompt) {
		super(prompt);
	}

	@Override
	public void run() {
		System.out.printf("%s\n%s\n", algorithmOption.getOptionName(), algorithmOption.getOptionDescription());
		InvalidInputHandler.promptIfInvalidValue(this::promptLine, EMPTY_STRING_MSG);
		int polidromeLenght = Algorithms.longestPalindromeSubseq(line);
		System.out.printf("The length of polidrome : %s  = %d \n ", line, polidromeLenght);
		
	}
	
	private boolean promptLine() {
		line = prompt.nextLine();
		return !line.isEmpty();
	}

}
