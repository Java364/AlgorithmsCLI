package com.softserve.algorithms;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class AlgorithmsTest {

    @Test(expected = NegativeArraySizeException.class)
    public void testFindingMaxSumOfPossibleDailyTasks(){
        Algorithms.findingMaxSumOfPossibleDailyTasks(new int[]{1,2,5,7},new int[]{10,4,3,1,7},-9);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFindingMaxSumOfPossibleDailyTasks1(){
        Algorithms.findingMaxSumOfPossibleDailyTasks(new int[]{1,2,-15,7},new int[]{10,4,3,1,7},6);
    }
    @Test
    public void testFindingMaxSumOfPossibleDailyTasks2(){
        int expectedResult = 20;
        int actualResult = Algorithms.findingMaxSumOfPossibleDailyTasks(new int[]{3,6,8,7,6},new int[]{1,5,4,5,3},5);
        Assert.assertEquals(expectedResult,actualResult);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testFindingMaxWaysOfPaintingTheFence(){
        Algorithms.findingMaxWaysOfPaintingTheFence(4,0);
    }
    @Test
    public void testFindingMaxWaysOfPaintingTheFence1(){
        BigDecimal expectedResult = new BigDecimal(16);
       BigDecimal actualResult = Algorithms.findingMaxWaysOfPaintingTheFence(2,4);
       Assert.assertEquals(expectedResult,actualResult);
    }
    @Test
    public void testFindingMaxWaysOfPaintingTheFence2(){
         Algorithms.findingMaxWaysOfPaintingTheFence(21,2147483647);

    }
    @Test
    public void testLongestSubsetWithPositiveNumbers() {
        int expectedResult = 3;
        int actualResult = Algorithms.longestSubset(new int[]{1, 2, 3, 7, 8});
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindFibonacciMemberWithStepZero() {
        int expectedResult = 8;
        int actualResult = Algorithms.findFibonacciMember(6, 0);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testFindFibonacciMemberWithStepOne() {
        int expectedResult = 4;
        int actualResult = Algorithms.findFibonacciMember(6, 1);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFibonacciMemberWithNegativeNumber() {
        Algorithms.findFibonacciMember(-34, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testFindLongestSubsetWithNullValue() {
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

    @Test (expected = IllegalArgumentException.class)
    public void testInterestingRowNegativeNumber() {
    	Algorithms.interestingRow(-3);
    }

    @Test
    public void testInterestingRowFirstElement() {
    	int expect = 1;
    	int base = 1;
    	assertEquals(expect, Algorithms.interestingRow(base));
    }

    @Test
    public void testInterestingRow() {
    	int expect = 11;
    	int base = 5;
    	assertEquals(expect, Algorithms.interestingRow(base));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testInterestingRowZeroNumber() {
    	Algorithms.interestingRow(0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testWaysToWriteNAsSumOfTwoOrMorePositiveIntegersNegativeNumber() {
    	Algorithms.waysToWriteNAsSumOfTwoOrMorePositiveIntegers(-6);
    }
    
    @Test()
    public void testWaysToWriteNAsSumOfTwoOrMorePositiveIntegersZeroNumber() {
    	int expect = 1;
    	assertEquals(expect, Algorithms.waysToWriteNAsSumOfTwoOrMorePositiveIntegers(0));
    	
    }
    
    @Test
    public void testWaysToWriteNAsSumOfTwoOrMorePositiveIntegers() {
    	int expect = 6;
    	int input = 5;
    	assertEquals(expect, Algorithms.waysToWriteNAsSumOfTwoOrMorePositiveIntegers(input));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindFibonacciMemberWhenStepIsBiggerThanNumber() {
        Algorithms.findFibonacciMember(0, 1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindFibonacciMemberWhenStepIsBiggerThanOne() {
        Algorithms.findFibonacciMember(8, 2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindFibonacciMemberWhenStepIsNegativeOne() {
        Algorithms.findFibonacciMember(8, -1);
    }

	@Test
	public void testWaysToSumUsingArrayOneElementArray() {
		assertEquals(1, WaysToSumUsingArray.getAllCombinationsOfSum(new int[] { 1 }, 1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWaysToSumArrayNegativeSum() throws Exception {
             WaysToSumUsingArray.getAllCombinationsOfSum(new int[] {1,2,3}, -5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWaysToSumArrayNegativeElementOfSequence() throws Exception {
             WaysToSumUsingArray.getAllCombinationsOfSum(new int[] {1,2,-3}, 5);
	}

	@Test
	public void PathWithoutCrossingWithFourElements() {
            assertEquals(5,PathWithoutCrossing.countPathsWithoutCrossing(6));
	}

	@Test
	public void PathWithoutCrossingWithOddNumber() {
            assertEquals(0,PathWithoutCrossing.countPathsWithoutCrossing(7));
	}

	@Test(expected = IllegalArgumentException.class)
	public void PathWithoutCrossingWithNegativeCount() throws Exception{
           PathWithoutCrossing.countPathsWithoutCrossing(-5);
	}

    @Test
    public void testLongestPalindromeSubseq(){
        int expected = 7;
        int result = Algorithms.longestPalindromeSubseq("AABBCDDDEEEEEEE");
        assertEquals(expected,result);
    }

    @Test
    public void testWaysToCoverIn3StepsAlgorithm(){
        int expected = 7;
        int result = Algorithms.waysToCoverIn3StepsAlgorithm(4);
        assertEquals(expected,result);
    }

    @Test(expected = NullPointerException.class)
    public void testLongestPalindromeSubseqException(){
        Algorithms.longestPalindromeSubseq("");
    }

    @Test(expected = Exception.class)
    public void testWaysToCoverIn3StepsAlgorithmException(){
        Algorithms.waysToCoverIn3StepsAlgorithm(1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFriendPairsNumberIsNull() {
        Algorithms.friendPairs(0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFriendPairsNumberIsNegative() {
        Algorithms.friendPairs(-100);
    }

    @Test
    public void testFriendPairsNumberIsThree() {
        BigInteger expected = new BigInteger("4");

        BigInteger actual = Algorithms.friendPairs(3);

        assertEquals(expected, actual);
    }

    @Test
    public void testFriendPairsNumberBigNumber() {
        BigInteger expected = new BigInteger("3672465781624551101825551243452039360153822596927411430303149111294268994479836539812914929926051742195976052634803552073005191131189152985503070701365227435309803806437354667813397115726462976");

        BigInteger actual = Algorithms.friendPairs(200);

        assertEquals(expected, actual);
    }
}
