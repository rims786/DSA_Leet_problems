package com.rimdome.dsa.leet1;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    @Test
    public void testTwoSum() throws TwoSum.TwoSumException {
        TwoSum twoSumObject = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {0, 1};
        assertArrayEquals(expectedResult, twoSumObject.twoSum(nums, target));
    }

    @Test(expected = TwoSum.TwoSumException.class)
    public void testTwoSumNoSolution() throws TwoSum.TwoSumException {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 20;
        twoSum.twoSum(nums, target);
    }
}