package com.softserve.algorithms;

public class WaysToSumUsingArray {
	
	public int getAllConbinationsOfSum(int sequence[], int sum) { 
        int count[] = new int[sum + 1]; 
        count[0] = 1; 
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < sequence.length; j++) {
                if (i >= sequence[j]) 
                    count[i] += count[i - sequence[j]]; 
            }
        }
        return count[sum];     
    } 

}
