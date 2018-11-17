package com.softserve.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testPaintingTheFencePostAreTwoColorAreFour() {
        BigDecimal expected = new BigDecimal(16);

        BigDecimal actual = Algorithms.countWaysPaintingTheFence(2, 4);

        assertEquals(expected, actual);
    }

    @Test
    public void testPaintingTheFencePostIsOneColorAreFour() {
        BigDecimal expected = new BigDecimal(4);

        BigDecimal actual = Algorithms.countWaysPaintingTheFence(1, 4);

        assertEquals(expected, actual);
    }

    @Test
    public void testPaintingTheFenceCheckBigValue() {
        BigDecimal expected = new BigDecimal("8716000251518839966464803175767138100592946456125862931906850885070054788361699042500");

        BigDecimal actual = Algorithms.countWaysPaintingTheFence(50, 50);

        assertEquals(expected, actual);
    }

    @Test
    public void countWaysToTileTheFloor1() {
        assertEquals(1, Algorithms.countWaysToTileTheFloor(2, 3));
    }

    @Test
    public void countWaysToTileTheFloor2() {
        assertEquals(2,  Algorithms.countWaysToTileTheFloor(4, 4));
    }


    @Test (expected = IllegalArgumentException.class)
    public void countWaysToTileTheFloorExceptionHandlingWithWrongN() {
        Algorithms.countWaysToTileTheFloor(0, 2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void countWaysToTileTheFloorExceptionHandlingWithWrongM() {
        Algorithms.countWaysToTileTheFloor(2, 1);
    }
    
    //testing interesting row method
    @Test (expected = IllegalArgumentException.class)
    public void testinterestingRowNegativeNumber() {
    	Algorithms.interestingRow(-3);
    }
    
    @Test
    public void testinterestingRowFirstElement() {
    	int expect = 1;
    	int base = 1;
    	assertEquals(expect, Algorithms.interestingRow(base));
    }
    
    @Test
    public void testinterestingRow() {
    	int expect = 11;
    	int base = 5;
    	assertEquals(expect, Algorithms.interestingRow(base));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testinterestingRowZeroNumber() {
    	Algorithms.interestingRow(0);
    }
}
