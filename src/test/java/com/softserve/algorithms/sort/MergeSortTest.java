package com.softserve.algorithms.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    private Sort sort;
    private int[] before;
    private int[] sorted;

    @Before
    public void setUp() throws Exception {
        before = new int[1000];
        for (int i = 0; i < before.length; i++) {
            before[i] = (int) (Math.random() * 1000);
        }
        sorted = Arrays.copyOf(before, before.length);
        Arrays.sort(sorted);
        sort = new MergeSort();
    }

    @Test
    public void sort() {
        assertArrayEquals(sorted, sort.sort(before));
    }
}
