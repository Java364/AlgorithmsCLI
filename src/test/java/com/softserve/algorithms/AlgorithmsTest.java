package com.softserve.algorithms;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AlgorithmsTest {
    @Test
    public void fibonacci() {
    }

    @Test
    public void longestSubset() {
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
}
