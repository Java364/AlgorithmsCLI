package com.demo.cli.impl.sort;

import com.demo.InvalidInputHandler;
import com.demo.algorithms.sort.Sort;
import com.demo.cli.AbstractCLI;
import com.demo.cli.type.AlgorithmOption;

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
        InvalidInputHandler.promptAgainIfInvalidValue(this::promptSequence);
        System.out.printf("Sorted sequence: %s \n", Arrays.toString(sortStrategy.sort(parsedSequence)));
    }

    public void setSortStrategy(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setAlgorithmOption(AlgorithmOption algorithmOption) {
        this.algorithmOption = algorithmOption;
    }
}
