package com.softserve.algorithms;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

public class Algorithms {

    public static int findFibonacciMember(int number, int step) {
        if (number < 0) {
            throw new IllegalArgumentException("Position of fibonacci number can't be negative.");
        }
        if ((step > number) || (step < 0) || (step > 1))
            throw new IllegalArgumentException("Incorrect step: " + step);
        int[] fibonacciSeeds = initFibonacciSeeds(step);
        int currentFibonacci = 0;
        int upperBound = number - (step > 0 ? 1 : 0);
        for (int i = 1; i <= upperBound; i++) {
            currentFibonacci = fibonacciSeeds[0] + fibonacciSeeds[fibonacciSeeds.length - 1];
            updateFibonacciSeed(fibonacciSeeds, currentFibonacci);
        }
        return currentFibonacci;
    }

    private static int[] initFibonacciSeeds(int step) {
        int[] fibonacciSeeds = new int[step + 2];
        fibonacciSeeds[fibonacciSeeds.length - 1] = 1;
        return fibonacciSeeds;
    }

    private static void updateFibonacciSeed(int[] fibonacciSeeds, int currentFibonacci) {
        int lastSeedIndex = fibonacciSeeds.length - 1;
        System.arraycopy(fibonacciSeeds, 1, fibonacciSeeds, 0, lastSeedIndex);
        fibonacciSeeds[lastSeedIndex] = currentFibonacci;
    }

    public static int longestSubset(int[] sequence) throws NullPointerException {
        Objects.requireNonNull(sequence, "Can't get longest subset from null sequence.");
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
     * @param posts  - number of posts
     * @param colors - number of colors
     * @return count of ways to color n posts using k colors
     * @throws IllegalArgumentException if values are less then one
     */
    public static BigDecimal countWaysPaintingTheFence(int posts, int colors) throws IllegalArgumentException {
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

  
    public static int findindMaxSumOfPossibleDailyTasks(int high[], int low[], int number) throws NegativeArraySizeException, IllegalArgumentException{
		if (number < 1) {
			throw new NegativeArraySizeException();
		}
		for (int i = 0; i < number; i++) {
			if (high[i] < 0 || low[i] < 0) {
				throw new IllegalArgumentException();
			}
		}
		
		comparingArrs(high, low, number);
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
    
    public static void comparingArrs(int arrHigh[], int arrLow[], int number) {
		for (int i = 0; i < number; i++) {
			int pr = 0;
			if (arrHigh[i] < arrLow[i]) {
				pr = arrHigh[i];
				arrHigh[i] = arrLow[i];
				arrLow[i] = pr;
			}
		}
	}
    
    public static BigDecimal findingMaxWaysOfPaintingTheFence(int numberOfPosts, int numberOfColors) throws IllegalArgumentException{
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
