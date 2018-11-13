package com.softserve.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BucketSortTest {

    private BucketSort bucketSort;

    @Before
    public void setUp() {
        bucketSort = new BucketSort();
    }

    @Test
    public void oneNumberArray() {
        int[] expected = new int[]{1};

        int[] actual = bucketSort.sort(new int[]{1});

        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoDifferentNumbersArray() {
        int[] expected = new int[]{1, 3};

        int[] actual = bucketSort.sort(new int[]{3, 1});

        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayWithPositiveNumbers() {
        int[] expected = new int[]{1, 3, 5, 9, 11, 11, 15, 17};

        int[] actual = bucketSort.sort(new int[]{15, 3, 9, 11, 1, 5, 17, 11});

        assertArrayEquals(expected, actual);
    }

    @Test
    public void arrayWithNegativeNumbers() {
        int[] expected = new int[]{-17, -15, -11, -11, -9, -5, -3, -1};

        int[] actual = bucketSort.sort(new int[]{-15, -3, -9, -11, -1, -5, -17, -11});

        assertArrayEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArrayIsNull() {
        int[] actual = bucketSort.sort(null);
    }

    @Test
    public void testBucketSorting() {
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(-10, -5, -2, 0, 1, 2, 5, 10));
        ArrayList<Integer> unsorted = new ArrayList<>(Arrays.asList(10, -10, 5, -5, 2, -2, 0, 1));

        ArrayList<Integer> actual = bucketSort.sortBucket(unsorted);

        assertEquals(expected, actual);
    }

    @Test
    public void testReturnBucketIndex() {
        int[] inputArray = new int[]{10, -10, 5, -5, 2, -2, 0, 1};
        int expectedIndex = 5;

        int actualIndex = bucketSort.returnBucketIndex(inputArray, 5);

        assertEquals(expectedIndex, actualIndex);
    }
}
