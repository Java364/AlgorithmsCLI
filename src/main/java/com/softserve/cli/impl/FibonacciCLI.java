package com.softserve.cli.impl;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class FibonacciCLI extends AbstractCLI implements CommandLineInterface {
    private int fibonacciPos  = 0;
    private int fibonacciStep = 0;

    public FibonacciCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getOptionName(), algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptFibonacciNumber, INVALID_NUMBER_MSG);
        InvalidInputHandler.promptIfInvalidValue(this::promptFibonacciStep, INVALID_NUMBER_MSG);
        int fibResult = Algorithms.findFibonacciMember(fibonacciPos, fibonacciStep);
        System.out.format("Fibonacci member at position %d with step %d is %d\n",
                          fibonacciPos, fibonacciStep, fibResult);
    }

    private boolean promptFibonacciNumber() {
        System.out.print("Please enter fibonacci member position(only positive integer numbers): ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        fibonacciPos = InputUtil.readIntValue(prompt);
        return fibonacciPos >= 0;
    }

    private boolean promptFibonacciStep() {
        System.out.print("Please enter step (0 or 1 only): ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        fibonacciStep = InputUtil.readIntValue(prompt);
        return (fibonacciStep == 0) || (fibonacciStep == 1);
    }
}
