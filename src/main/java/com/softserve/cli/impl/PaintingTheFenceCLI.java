package com.softserve.cli.impl;

import com.softserve.algorithms.Algorithms;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.util.InputUtil;

import java.math.BigDecimal;
import java.util.Scanner;

public class PaintingTheFenceCLI extends AbstractCLI {

    private int posts;
    private int colors;


    public PaintingTheFenceCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getOptionName(),
                algorithmOption.getOptionDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptPostsNumbers, INVALID_NUMBER_MSG);
        InvalidInputHandler.promptIfInvalidValue(this::promptColorNumbers, INVALID_NUMBER_MSG);

        BigDecimal result = Algorithms.countWaysPaintingTheFence(posts, colors);
        System.out.format("Number of ways to print the fence is %s\n", result);


    }

    private boolean promptPostsNumbers() {
        System.out.print("Please enter number of posts (only positive integer numbers): ");
        if (!InputUtil.hasNextInt(prompt)) {
            return false;
        }
        this.posts = InputUtil.readIntValue(prompt);

        return this.posts >= 1;
    }

    private boolean promptColorNumbers() {
        System.out.println("Please number of colors (only positive integer numbers): ");
        if (!InputUtil.hasNextInt(prompt)) {
            return false;
        }
        this.colors = InputUtil.readIntValue(prompt);

        return this.colors >= 1;
    }
}
