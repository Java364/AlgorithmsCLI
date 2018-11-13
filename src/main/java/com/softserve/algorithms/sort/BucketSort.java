package com.softserve.algorithms.sort;

import java.util.ArrayList;

public class BucketSort implements Sort {
    @Override
    public int[] sort(int[] input) {

        if (input == null) {
            throw new IllegalArgumentException("array can not be null");
        }

        if (input.length == 0 || input.length == 1) {
            return input;
        }

        Bucket[] buckets = new Bucket[input.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int number : input) {
            int bucketIndex = returnBucketIndex(input, number);
            buckets[bucketIndex].bucket.add(number);
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].bucket.size() > 1) {
                buckets[i].bucket = sortBucket(buckets[i].bucket);
            }
        }

        int[] result = new int[input.length];
        int resultIndex = 0;
        for (Bucket bucket : buckets) { //combine numbers from buckets
            if (bucket.bucket.size() > 0) {
                for (Integer i : bucket.bucket) {
                    result[resultIndex] = i;
                    resultIndex++;
                }
            }
        }
        return result;
    }

    int returnBucketIndex(int[] input, int number) {
        int max = input[0];
        int min = input[0];
        for (int i = 1; i < input.length; i++) {
            if (max < input[i]) {
                max = input[i];
            } else if (min > input[i]) {
                min = input[i];
            }
        }

        double sortingFunctionResult = (number - min) / (max - min + 1.0) * input.length;
        int bucketIndex = (int) sortingFunctionResult;
        return bucketIndex;
    }

    ArrayList<Integer> sortBucket(ArrayList<Integer> bucket) { //insertion sort algorithm for buckets

        for (int i = 1; i < bucket.size(); i++) {
            if (bucket.get(i) < bucket.get(i - 1)) {
                for (int j = i; j > 0; j--) {
                    if (bucket.get(j) < bucket.get(j - 1)) {
                        int temp = bucket.get(j);
                        bucket.set(j, bucket.get(j - 1));
                        bucket.set(j - 1, temp);
                    }
                }
            }
        }
        return bucket;
    }


    class Bucket {

        ArrayList<Integer> bucket = new ArrayList<>();

        @Override
        public String toString() {
            return "Bucket{" +
                    "bucket=" + bucket +
                    '}';
        }
    }

}
