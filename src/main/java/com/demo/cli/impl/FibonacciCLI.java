package com.demo.cli.impl;

import com.demo.InvalidInputHandler;
import com.demo.algorithms.Algorithms;
import com.demo.cli.AbstractCLI;
import com.demo.cli.CommandLineInterface;
import com.demo.cli.util.InputUtil;

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
