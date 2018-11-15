package com.softserve.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class AlgorithmsTest {

    @Test
    public void testLongestSubsetWithPositiveNumbers() {
        int expectedResult = 3;
        int actualResult = Algorithms.longestSubset(new int[]{1, 2, 3, 7, 8});
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindFibonacciMember() {
        int expectedResult = 8;
        int actualResult = Algorithms.findFibonacciMember(5);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFibonacciMemberWithNegativeNumber() throws Exception {
        Algorithms.findFibonacciMember(-34);
    }

    @Test(expected = NullPointerException.class)
    public void testFindLongestSubsetWithNullValue() throws Exception {
        Algorithms.longestSubset(null);
    }
}
