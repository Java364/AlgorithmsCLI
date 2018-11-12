package com.softserve.cli.impl;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class TilingTheFloorCLI extends AbstractCLI implements CommandLineInterface {
    private int n = 0;
    private int m = 0;

    public TilingTheFloorCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getOptionName(),
                algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptNParamethers, INVALID_NUMBER_MSG);
        InvalidInputHandler.promptIfInvalidValue(this::promptMParamethers, INVALID_NUMBER_MSG);
        System.out.format("If we have n = %d and m = %d, the result is %d\n", n, m, Algorithms.countWaysToTileTheFloor(n, m));
    }

    private boolean promptNParamethers() {
        System.out.print("Please enter n(only positive integer numbers): ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.n = InputUtil.readIntValue(prompt);
        return this.n>=1;
    }

    private boolean promptMParamethers() {
        System.out.print("Please enter m(only positive integer numbers and >=2): ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.m = InputUtil.readIntValue(prompt);
        return this.m >= 2;
    }
}
