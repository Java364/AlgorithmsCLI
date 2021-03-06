package com.softserve.algorithms;

public class PathWithoutCrossing {
	
	public static int countPathsWithoutCrossing (int numberPoints) throws IllegalArgumentException{
    	if(numberPoints < 0) {
    		throw new IllegalArgumentException("count of numbers cann't be negative");
    	}
		
		if(numberPoints%2 == 1) {
    		return 0;
    	}
    	int tempNumberPoints = numberPoints/2;
    	int[] temp = new int [tempNumberPoints + 1]; 
    	temp[0] = temp[1] = 1;
    	for (int i = 2; i <= tempNumberPoints; i++) { 
            temp[i] = 0; 
            for (int j = 0; j < i; j++)  {
                temp[i] += temp[j] * temp[i - j - 1]; 
            }
        } 
    	return temp[tempNumberPoints];
    }

}
