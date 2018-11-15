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
    
    public static int findindMaxSumOfPossibleDailyTasks(int high[], int low[], int number) {
		if (number < 1) {
			throw new NegativeArraySizeException();
		}
		for (int i = 0; i < number; i++) {
			if (high[i] < 0 || low[i] < 0) {
				throw new IllegalArgumentException();
			}
		}
		int localArray[] = new int[number + 1];
		localArray[0] = 0;
		localArray[1] = high[0];
		for (int i = 2; i <= number; i++)
			localArray[i] = findingMaxIntAlgorithm(high[i - 1] + localArray[i - 2], low[i - 1] + localArray[i - 1]);
		return localArray[number];
	}
    
    public static int findingMaxIntAlgorithm(int firstNumber, int secondNumber) {
		if (firstNumber > secondNumber) {
			return firstNumber;
		} else {
			return secondNumber;
		}
	}
    
    public static BigDecimal findingMaxWaysOfPaintingTheFence(int numberOfPosts, int numberOfColors) {
    	if (numberOfPosts <= 0 || numberOfColors <= 0) {
			throw  new IllegalArgumentException();
		}
    	
    	if (numberOfPosts == 1) {
			BigDecimal bd = new BigDecimal(numberOfColors);
			return bd;
		}

		BigDecimal[] localArrayOne = new BigDecimal[numberOfPosts];
		BigDecimal[] localArrayTwo = new BigDecimal[numberOfPosts];

		localArrayOne[0] = BigDecimal.valueOf(0);
		localArrayTwo[0] = BigDecimal.valueOf(numberOfColors);
		for (int i = 1; i < numberOfPosts; i++) {
			localArrayOne[i] = localArrayTwo[i - 1];
			localArrayTwo[i] = new BigDecimal(numberOfColors - 1).multiply(localArrayOne[i - 1].add(localArrayTwo[i - 1]));
		}
		BigDecimal bd = localArrayOne[numberOfPosts - 1].add(localArrayTwo[numberOfPosts - 1]);
		
		return bd;
	}
}
