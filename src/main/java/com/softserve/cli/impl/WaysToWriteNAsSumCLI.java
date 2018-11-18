package com.softserve.cli.impl;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class WaysToWriteNAsSumCLI extends AbstractCLI implements CommandLineInterface {
    private int number = 0;

    public WaysToWriteNAsSumCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getOptionName(),
                          algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptWaysToWriteNAsSum, INVALID_NUMBER_MSG);
        int ways = Algorithms.FriendPairs(number);
        System.out.format("Ways to write number %d as sum is %d\n", number, ways);
    }

    private boolean promptWaysToWriteNAsSum() {
        System.out.print("Please, enter number the number: ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.number = InputUtil.readIntValue(prompt);
        return this.number >= 1;
    }
}
