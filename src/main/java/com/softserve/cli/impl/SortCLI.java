package com.softserve.cli.impl;

import com.softserve.InvalidInputHandler;
import com.softserve.algorithms.sort.Sort;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.option.AlgorithmOption;

import java.util.Arrays;
import java.util.Scanner;

public class SortCLI extends AbstractCLI {
    private Sort sortStrategy;

    public SortCLI(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        System.out.printf("%s\n%s\n", algorithmOption.getAlgorithmName(),
                          algorithmOption.getAlgorithmDescription());
        InvalidInputHandler.promptIfInvalidValue(this::promptSequence, BAD_SEQUENCE_FORMAT_MSG);
        System.out.printf("Sorted sequence: %s \n", Arrays.toString(sortStrategy.sort(parsedSequence)));
    }

    public void setSortStrategy(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setAlgorithmOption(AlgorithmOption algorithmOption) {
        this.algorithmOption = algorithmOption;
    }
}
