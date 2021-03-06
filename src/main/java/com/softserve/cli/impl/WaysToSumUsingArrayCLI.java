package com.softserve.cli.impl;

import com.softserve.algorithms.WaysToSumUsingArray;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.ArrayUtil;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class WaysToSumUsingArrayCLI extends AbstractCLI implements CommandLineInterface {
    private int sum;

    public WaysToSumUsingArrayCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getOptionName(), algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptSequence, BAD_SEQUENCE_FORMAT_MSG);
        InvalidInputHandler.promptIfInvalidValue(this::promptSum, INVALID_NUMBER_MSG);
        int result = WaysToSumUsingArray.getAllCombinationsOfSum(parsedSequence, sum);
        System.out.format("To represent %d we can such ways: %d\n", sum, result);
    }

    @Override
    protected boolean promptSequence() {
        System.out.print("Please enter sequence (e.g '1 2 3') of positive integer numbers: ");
        String sequence = prompt.nextLine();
        this.parsedSequence = ArrayUtil.parseIntegerSequence(sequence);
        return sequenceHasNegativeNumbers();
    }

    private boolean sequenceHasNegativeNumbers() {
        int i = 0;
        int sequenceLength = parsedSequence.length;
        while (i < sequenceLength && parsedSequence[i] > 0) {
            i++;
        }
        return sequenceLength == i;
    }

    private boolean promptSum() {
        System.out.print("Please enter the sum: ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.sum = InputUtil.readIntValue(prompt);
        return this.sum >= 1;
    }
}
