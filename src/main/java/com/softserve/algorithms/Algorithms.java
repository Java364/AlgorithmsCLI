package com.softserve.algorithms;

import java.math.BigDecimal;
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


    public static int countWaysToTileTheFloor(int n, int m) {
        if (m < 2 || n < 1) {
            throw new IllegalArgumentException();
        } else {
            int count[] = new int[n + 1];
            count[0] = 0;
            int i;
            for (i = 1; i <= n; i++) {
                if (i > m)
                    count[i] = count[i - 1] + count[i - m];
                else if (i < m)
                    count[i] = 1;
                else
                    count[i] = 2;
            }
            return count[n];
        }
    }

    /**
     *
     * @param posts - number of posts
     * @param colors - number of colors
     * @return count of ways to color n posts using k colors
     */
    public static BigDecimal countWaysPaintingTheFence(int posts, int colors) {
        if (posts < 1 || colors < 1) {
            throw new IllegalArgumentException("Posts and colors must be positive");
        }

        BigDecimal total = new BigDecimal(colors);

        BigDecimal same;
        BigDecimal diff = new BigDecimal(colors);

        for (int i = 2; i <= posts; i++) {
            same = diff;
            diff = total.multiply(new BigDecimal(colors - 1));
            total = same.add(diff);
        }
        return total;
    }
}
