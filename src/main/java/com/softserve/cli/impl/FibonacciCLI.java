package com.softserve.cli.impl;

import com.softserve.InvalidInputHandler;
import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class FibonacciCLI extends AbstractCLI implements CommandLineInterface {
    private int fibonacciPos = 0;

    public FibonacciCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getAlgorithmName(),
                          algorithmOption.getAlgorithmDescription());
        InvalidInputHandler.promptAgainIfInvalidValue(this::promptFibonacciNumber);
        System.out.format("Fibonacci member at position %d is %d\n", fibonacciPos,
                          Algorithms.fibonacci(fibonacciPos));
    }

    private boolean promptFibonacciNumber() {
        System.out.println("Please enter fibonacci position");
        InvalidInputHandler.promptIntAgainIfInvalid(prompt);
        this.fibonacciPos = InputUtil.readIntValue(prompt);
        return this.fibonacciPos >= 1;
    }
}
