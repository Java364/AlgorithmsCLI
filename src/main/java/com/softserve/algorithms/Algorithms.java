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
    
    public static int findindMaxSumOfPossibleDailyTasks(int high[], int low[], int n) {
		if (n < 1) {
			throw new NegativeArraySizeException();
		}
		for (int i = 0; i < n; i++) {
			if (high[i] < 0 || low[i] < 0) {
				throw new IllegalArgumentException();
			}
		}
		int taskDp[] = new int[n + 1];
		taskDp[0] = 0;
		taskDp[1] = high[0];
		for (int i = 2; i <= n; i++)
			taskDp[i] = findingMaxIntAlgorithm(high[i - 1] + taskDp[i - 2], low[i - 1] + taskDp[i - 1]);
		return taskDp[n];
	}
    
    public static int findingMaxIntAlgorithm(int x, int y) {
		if (x > y) {
			return x;
		} else {
			return y;
		}
	}
    
    public static BigDecimal findingMaxWaysOfPaintingTheFence(int n, int k) {
    	if (n <= 0 || k <= 0) {
			throw  new IllegalArgumentException();
		}
    	
    	if (n == 1) {
			BigDecimal bd = new BigDecimal(k);
			return bd;
		}

		BigDecimal[] dp1 = new BigDecimal[n];
		BigDecimal[] dp2 = new BigDecimal[n];

		dp1[0] = BigDecimal.valueOf(0);
		dp2[0] = BigDecimal.valueOf(k);
		for (int i = 1; i < n; i++) {
			dp1[i] = dp2[i - 1];
			dp2[i] = new BigDecimal(k - 1).multiply(dp1[i - 1].add(dp2[i - 1]));
		}
		BigDecimal bd = dp1[n - 1].add(dp2[n - 1]);
		
		return bd;
	}
}
