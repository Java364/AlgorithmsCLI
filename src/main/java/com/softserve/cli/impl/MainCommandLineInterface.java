package com.softserve.cli.impl;

import com.softserve.algorithms.sort.*;
import com.softserve.cli.AbstractCLI;
import com.softserve.cli.CommandLineInterface;
import com.softserve.cli.InvalidInputHandler;
import com.softserve.cli.option.AlgorithmOption;
import com.softserve.cli.option.CommonAlgorithmOption;
import com.softserve.cli.option.SortAlgorithmOption;
import com.softserve.cli.util.InputUtil;

import java.util.Scanner;

public class MainCommandLineInterface extends AbstractCLI implements CommandLineInterface {
    private static final String NO_OPTION_MSG = "You've entered non-existing option.";

    private static final CommonAlgorithmOption[] ALGORITHMS_OPTIONS;
    private static final SortAlgorithmOption[] SORT_ALGORITHMS_OPTIONS;

    static {
        ALGORITHMS_OPTIONS = CommonAlgorithmOption.values();
        SORT_ALGORITHMS_OPTIONS = SortAlgorithmOption.values();
    }

    private AbstractCLI mainCLI;
    private AlgorithmOption algorithmOption;
    private int userOption;

    public MainCommandLineInterface(Scanner prompt) {
        super(prompt);
    }

    @Override
    public void run() {
        boolean exitRequested = false;
        while (!exitRequested) {
            InvalidInputHandler.promptIfInvalidValue(() -> promptOption(ALGORITHMS_OPTIONS),
                    NO_OPTION_MSG);
            CommonAlgorithmOption commonAlgorithmOption = ALGORITHMS_OPTIONS[userOption];
            algorithmOption = commonAlgorithmOption;
            switch (commonAlgorithmOption) {
                case EXIT:
                    exitRequested = true;
                    System.out.println(algorithmOption.getOptionDescription());
                    break;
                case SORT:
                    System.out.println(algorithmOption.getOptionDescription());
                    mainCLI = new SortCLI(prompt);
                    callSortCLI();
                    continue;
                case FIBONACCI:
                    mainCLI = new FibonacciCLI(prompt);
                    break;
                case LONGEST_SUBSEQUENCE:
                    mainCLI = new LongestSubsequenceCLI(prompt);
                    break;
                case TILING_THE_FLOOR:
                    mainCLI = new TilingTheFloorCLI(prompt);
                    break;
                case PATH_WITHOUT_CROSSING:
                    mainCLI = new PathWithoutCrossingCLI(prompt);
                    break;
                case WAYS_TO_SUM_USING_ARRAY:
                    mainCLI = new WaysToSumUsingArrayCLI(prompt);
                    break;
                case PAINTING_THE_FENCE:
                    mainCLI = new PaintingTheFenceCLI(prompt);
                    break;
                case OPTIMIZED_PAINTING_FENCE:
                	  mainCLI = new OptimizedPaintingFence(prompt);
                	  break;
                case MAX_POSSIBLE_DAILY_TASKS:
                	  mainCLI = new MaxPossibleDailyTasksCLI(prompt);
                	  break;
                case FRIEND_PAIRS:
                    mainCLI = new FriendPairsCLI(prompt);
                    break;
                case WAYS_TO_WRITE_N_AS_SUM:
                    mainCLI = new WaysToWriteNAsSumCLI(prompt);
                    break;
                case INTRESTING_ROW:
                      mainCLI = new InterstingRowCLI(prompt);
                      break;
                case LONGEST_POLIDROME:
                	mainCLI = new LongestPolidromeCLI(prompt);
                	break;
                case WAYS_TO_COVER_DISTANCE_IN_3_STEPS:
                	mainCLI = new WayToCoverIn3StepsCLI(prompt);
                	break;

            }
            runCliIfExitNotRequested(exitRequested);
        }
    }

    private void callSortCLI() {
        SortCLI sortCLI = (SortCLI) mainCLI;
        boolean exitRequested = false;
        while (!exitRequested) {
            InvalidInputHandler.promptIfInvalidValue(() -> promptOption(SORT_ALGORITHMS_OPTIONS),
                    NO_OPTION_MSG);
            SortAlgorithmOption sortAlgorithmOption = SORT_ALGORITHMS_OPTIONS[userOption];
            algorithmOption = sortAlgorithmOption;
            switch (sortAlgorithmOption) {
                case EXIT:
                    exitRequested = true;
                    System.out.println(algorithmOption.getOptionDescription());
                    break;
                case MERGE_SORT:
                    sortCLI.setSortStrategy(new MergeSort());
                    break;
                case COUNTING_SORT:
                    sortCLI.setSortStrategy(new CountingSort());
                    break;
                case INSERTION_SORT:
                    sortCLI.setSortStrategy(new InsertionSort());
                    break;
                case QUICK_SORT:
                    sortCLI.setSortStrategy(new QuickSort());
                    break;
                case BUCKET_SORT:
                    sortCLI.setSortStrategy(new BucketSort());
                    break;
            }
            runCliIfExitNotRequested(exitRequested);
        }
    }

    private void runCliIfExitNotRequested(boolean exitRequested) {
        if (!exitRequested) {
            mainCLI.setAlgorithmOption(algorithmOption);
            mainCLI.run();
            System.out.println("Please enter any key to return to a menu.");
            prompt.nextLine();
        }
    }

    private static <E extends Enum<E> & AlgorithmOption> void displayMenu(Enum<E>[] options) {
        final AlgorithmOption[] algorithmOptions = (AlgorithmOption[]) options;
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d: %s\n", i, algorithmOptions[i].getOptionName());
        }
    }

    private <E extends Enum<E> & AlgorithmOption> boolean promptOption(Enum<E>[] options) {
        displayMenu(options);
        if (InputUtil.hasNextInt(prompt)) {
            this.userOption = InputUtil.readIntValue(prompt);
            return doesOptionExists(options);
        }
        return false;
    }

    private <E extends Enum<E>> boolean doesOptionExists(Enum<E>[] options) {
        return userOption >= 0 && userOption <= options.length;
    }
}
