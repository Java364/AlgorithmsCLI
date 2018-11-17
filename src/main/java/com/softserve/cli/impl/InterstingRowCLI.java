package com.softserve.cli.impl;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;


public class InterstingRowCLI extends AbstractCLI {
    private int base;

    public InterstingRowCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getOptionName(),
                algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptBase, INVALID_NUMBER_MSG);

        System.out.printf("Number %d%n", Algorithms.interestingRow( base));

    }

    private boolean promptBase() {
        System.out.println("Enter positive integer number: ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.base = InputUtil.readIntValue(prompt);
        return this.base >= 1;
    }
}
