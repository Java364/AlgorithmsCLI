package com.softserve.cli.impl;

import com.softserve.InvalidInputHandler;
import com.softserve.algorithms.sort.CountingSort;
import com.softserve.algorithms.sort.MergeSort;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.option.AlgorithmOption;
import com.softserve.cli.option.CommonAlgorithmOption;
import com.softserve.cli.option.SortAlgorithmOption;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class MainCommandLineInterface extends AbstractCLI implements CommandLineInterface {
    private static final CommonAlgorithmOption[] ALGORITHMS_OPTIONS;
    private static final SortAlgorithmOption[]   SORT_ALGORITHMS_OPTIONS;

    static {
        ALGORITHMS_OPTIONS = CommonAlgorithmOption.values();
        SORT_ALGORITHMS_OPTIONS = SortAlgorithmOption.values();
    }

    private AbstractCLI     mainCLI;
    private AlgorithmOption algorithmOption;
    private int             userOption;

    public MainCommandLineInterface(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        boolean exitRequested = false;
        while (!exitRequested) {
            InvalidInputHandler.promptIfInvalidValue(() -> promptOption(ALGORITHMS_OPTIONS));
            CommonAlgorithmOption commonAlgorithmOption = ALGORITHMS_OPTIONS[userOption];
            algorithmOption = ALGORITHMS_OPTIONS[userOption];
            switch (commonAlgorithmOption) {
            case EXIT:
                exitRequested = true;
                System.out.println(algorithmOption.getAlgorithmDescription());
                break;
            case SORT:
                System.out.println(algorithmOption.getAlgorithmDescription());
                mainCLI = new SortCLI(super.prompt);
                callSortCLI();
                continue;
            case FIBONACCI:
                mainCLI = new FibonacciCLI(this.prompt);
                break;
            case LONGEST_SUBSEQUENCE:
                mainCLI = new LongestSubsequenceCLI(prompt);
                break;
            }
            runCliIfExitNotRequested(exitRequested);
        }
    }

    private void callSortCLI() {
        SortCLI sortCLI = (SortCLI) mainCLI;
        boolean exitRequested = false;
        while (!exitRequested) {
            InvalidInputHandler.promptIfInvalidValue(() -> promptOption(SORT_ALGORITHMS_OPTIONS));
            SortAlgorithmOption sortAlgorithmOption = SORT_ALGORITHMS_OPTIONS[userOption];
            algorithmOption = SORT_ALGORITHMS_OPTIONS[userOption];
            switch (sortAlgorithmOption) {
            case EXIT:
                exitRequested = true;
                System.out.println(algorithmOption.getAlgorithmDescription());
                break;
            case MERGE_SORT:
                sortCLI.setSortStrategy(new MergeSort());
                break;
            case COUNTING_SORT:
                sortCLI.setSortStrategy(new CountingSort());
                break;
            }
            runCliIfExitNotRequested(exitRequested);
        }
    }

    private void runCliIfExitNotRequested(boolean exitRequested) {
        if (!exitRequested) {
            mainCLI.setAlgorithmOption(algorithmOption);
            mainCLI.run();
        }
    }

    private static <E extends Enum<E> &  AlgorithmOption> void displayMenu(Enum<E>[] options) {
        final AlgorithmOption[] algorithmOptions = (AlgorithmOption[]) options;
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d: %s\n", i, algorithmOptions[i].getAlgorithmName());
        }
    }

    private <E extends Enum<E> & AlgorithmOption> boolean promptOption(Enum<E>[] options) {
        displayMenu(options);
        if (InputUtil.hasNextInt(prompt)) {
            this.userOption = InputUtil.readIntValue(prompt);
            if (doesOptionExists(options)) {
                return true;
            }
        }
        System.out.println("You've entered non-existing option.");
        return false;
    }

    private <E extends Enum<E>> boolean doesOptionExists(Enum<E>[] options) {
        return userOption >= 0 && userOption <= options.length;
    }
}
