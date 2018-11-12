package com.softserve.algorithms;

public class WaysToSumUsingArray {
	
	public int waysToSumToNUsingArrayElementsWithRepetitionExecute(int array[], int n) { 
        int count[] = new int[n + 1]; 
        count[0] = 1; 
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i >= array[j]) 
                    count[i] += count[i - array[j]]; 
            }
        }
        return count[n];     
    } 

}
