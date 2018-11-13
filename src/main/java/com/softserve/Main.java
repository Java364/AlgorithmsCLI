package com.softserve;

import com.softserve.cli.AbstractCLI;
import com.softserve.cli.impl.FibonacciCLI;
import com.softserve.cli.impl.LongestSubsequenceCLI;
import com.softserve.cli.impl.MainCommandLineInterface;
import com.softserve.cli.option.CommonAlgorithmOption;

import java.io.IOException;
import java.util.Scanner;
import java.util.function.BooleanSupplier;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final AbstractCLI fibonacciCLI = new LongestSubsequenceCLI(scanner);
            fibonacciCLI.setAlgorithmOption(CommonAlgorithmOption.LONGEST_SUBSEQUENCE);
            fibonacciCLI.run();
        }
    }

    public static boolean test() {
        throw new RuntimeException();
    }
}
