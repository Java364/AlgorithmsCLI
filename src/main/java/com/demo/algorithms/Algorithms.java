package com.demo.algorithms;

import java.util.Arrays;

public class Algorithms {
    public static int fibonacci(int number) {
        int term1 = 0;
        int term2 = 1;
        int termSum = 0;
        for (int i = 1; i <= number; i++) {
            termSum = term1 + term2;
            term1 = term2;
            term2 = termSum;
        }
        return termSum;
    }

    public static int longestSubset(int[] sequence) {
        int[] sequenceCopy = Arrays.copyOf(sequence, sequence.length);
        int subSequenceSize = 1;
        int max = 0;
        Arrays.sort(sequenceCopy);
        for (int i = 0; i < sequenceCopy.length - 1; i++) {
            if (isDifferentByOne(sequenceCopy[i], sequenceCopy[i + 1])) {
                subSequenceSize++;
                max = Math.max(max, subSequenceSize);
            } else {
                subSequenceSize = 1;
            }
        }
        return max;
    }

    private static boolean isDifferentByOne(int el1, int el2) {
        return (el2 - el1) == 1;
    }
}
