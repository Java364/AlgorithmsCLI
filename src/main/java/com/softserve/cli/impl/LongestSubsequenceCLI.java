package com.softserve.cli.impl;

import com.softserve.InvalidInputHandler;
import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;

import java.util.Scanner;

public class LongestSubsequenceCLI extends AbstractCLI implements CommandLineInterface {

    public LongestSubsequenceCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getAlgorithmName(),
                          algorithmOption.getAlgorithmDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptSequence, BAD_SEQUENCE_FORMAT_MSG);
        System.out.format("Longest subsequence %d\n", Algorithms.longestSubset(parsedSequence));
    }
}
