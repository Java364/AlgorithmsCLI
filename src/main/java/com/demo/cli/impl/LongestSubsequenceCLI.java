package com.demo.cli.impl;

import com.demo.InvalidInputHandler;
import com.demo.algorithms.Algorithms;
import com.demo.cli.AbstractCLI;
import com.demo.cli.CommandLineInterface;

import java.util.Scanner;

public class LongestSubsequenceCLI extends AbstractCLI implements CommandLineInterface {

    public LongestSubsequenceCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getAlgorithmName(),
                          algorithmOption.getAlgorithmDescription());
        InvalidInputHandler.promptAgainIfInvalidValue(this::promptSequence);
        System.out.format("Longest subsequence %d\n", Algorithms.longestSubset(parsedSequence));
    }
}
