package com.softserve.algorithms;

public class WaysToSumUsingArray {
	
	public int getAllCombinationsOfSum(int sequence[], int sum) throws IllegalArgumentException{
        
		if(sum <= 0) {
			throw new IllegalArgumentException("sum cann't be negative or equel zero");
		}
		for(int e: sequence) {
			if(e < 0) {
				throw new IllegalArgumentException("number of sequence cann't be negative");
			}
		}
		
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
