package com.softserve.algorithms.sort;

public class InsertionSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                for (int j = i; j > 0; j--) {
                    if (array[j]<array[j-1]){
                        int swap = array[j];
                        array[j] = array[j-1];
                        array[j-1] = swap;
                    }
                }

            }

        }
        return array;
    }
}
