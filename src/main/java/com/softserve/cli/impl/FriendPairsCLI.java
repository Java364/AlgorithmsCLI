package com.softserve.cli.impl;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class FriendPairsCLI extends AbstractCLI implements CommandLineInterface {
    private int friendPairs = 0;

    public FriendPairsCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getOptionName(),
                          algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptFriendPairs, INVALID_NUMBER_MSG);
        int friendPair = Algorithms.FriendPairs(friendPairs);
        System.out.format("Friend pairs is %d\n", friendPair);
    }

    private boolean promptFriendPairs() {
        System.out.print("Please, enter number of friends: ");
        if (!InputUtil.hasNextInt(prompt))
            return false;
        this.friendPairs = InputUtil.readIntValue(prompt);
        return this.friendPairs >= 1;
    }
}
