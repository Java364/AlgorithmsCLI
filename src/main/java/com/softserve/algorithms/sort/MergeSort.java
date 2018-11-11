package com.softserve.algorithms.sort;

public class MergeSort implements Sort {

    public int[] sort(int[] input) {
        int lenght = input.length;
        if (lenght <= 1) {
            return input;
        }
        int leftArr[] = new int[lenght / 2];
        int rightArr[] = new int[lenght - lenght / 2];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = input[i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = input[i + leftArr.length];
        }
        return merge(sort(leftArr), sort(rightArr));
    }

    public int[] merge(int[] leftArr, int[] rightArr) {
        int[] resultArr = new int[leftArr.length + rightArr.length];
        int leftLenght = leftArr.length;
        int rightLenght = rightArr.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLenght && j < rightLenght) {
            if (leftArr[i] < rightArr[j]) {
                resultArr[k] = leftArr[i];
                i++;
                k++;
            } else {
                resultArr[k] = rightArr[j];
                j++;
                k++;
            }
        }
        while (i < leftLenght) {
            resultArr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < rightLenght) {
            resultArr[k] = rightArr[j];
            j++;
            k++;
        }
        return resultArr;
    }
}
