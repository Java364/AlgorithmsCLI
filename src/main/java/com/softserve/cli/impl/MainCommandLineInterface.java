package com.softserve.cli.impl;

import com.softserve.InvalidInputHandler;
import com.softserve.algorithms.sort.CountingSort;
import com.softserve.algorithms.sort.MergeSort;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.impl.sort.SortCLI;
import com.softserve.cli.option.AlgorithmOption;
import com.softserve.cli.option.CommonAlgorithmsOption;
import com.softserve.cli.option.SortAlgorithmsOption;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class MainCommandLineInterface extends AbstractCLI implements CommandLineInterface {
    private static final CommonAlgorithmsOption[] COMMON_ALGORITHMS_TYPE;
    private static final SortAlgorithmsOption[]   SORT_ALGORITHMS_TYPES;

    static {
       COMMON_ALGORITHMS_TYPE = CommonAlgorithmsOption.values();
       SORT_ALGORITHMS_TYPES = SortAlgorithmsOption.values();
    }

    private AbstractCLI     mainCLI;
    private AlgorithmOption algorithmOption;

    public MainCommandLineInterface(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        boolean exitRequested = false;
        while (!exitRequested) {
            displayMainMenu();
            InvalidInputHandler.promptIntAgainIfInvalid(prompt);
            int option = InputUtil.readIntValue(prompt);
            if (option > COMMON_ALGORITHMS_TYPE.length || option < 0) {
                System.out.println("You've entered non-existing option.");
                continue;
            }
            CommonAlgorithmsOption commonAlgorithmsType;
            commonAlgorithmsType = (CommonAlgorithmsOption) (algorithmOption = COMMON_ALGORITHMS_TYPE[option]);
            switch (commonAlgorithmsType) {
            case EXIT:
                exitRequested = true;
                System.out.println(algorithmOption.getAlgorithmDescription());
                break;
            case SORT:
                System.out.println(algorithmOption.getAlgorithmDescription());
                mainCLI = new SortCLI(super.prompt);
                promptSortOption();
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

    private static void displayMainMenu() {
        for (int i = 0; i < COMMON_ALGORITHMS_TYPE.length; i++) {
            System.out.printf("%d: %s\n", i, COMMON_ALGORITHMS_TYPE[i].getAlgorithmName());
        }
    }

    private static void displaySortMenu() {
        for (int i = 0; i < SORT_ALGORITHMS_TYPES.length; i++) {
            System.out.printf("%d: %s\n", i, SORT_ALGORITHMS_TYPES[i].getAlgorithmName());
        }
    }

    private void promptSortOption() {
        SortCLI sortCLI = (SortCLI) mainCLI;
        boolean exitRequested = false;
        while (!exitRequested) {
            displaySortMenu();
            int option = InputUtil.readIntValue(prompt);
            if (option > COMMON_ALGORITHMS_TYPE.length || option < 0) {
                System.out.println("You've entered non-existing option.");
                continue;
            }
            SortAlgorithmsOption sortAlgorithmsOption;
            sortAlgorithmsOption = (SortAlgorithmsOption) (algorithmOption = SORT_ALGORITHMS_TYPES[option]);
            switch (sortAlgorithmsOption) {
            case EXIT:
                exitRequested = true;
                System.out.println(algorithmOption.getAlgorithmDescription());
                break;
            case MERGE_SORT:
                sortCLI.setSortStrategy(new MergeSort());
                break;
                case COUNTING_SORT:
                    sortCLI.setSortStrategy(new CountingSort());
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
}
