package com.rimdome.dsa.leet1;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class provides a solution to the Leet problem TwoSum.
 *
 * @author Rimmy Uddin.
 * @version 1.0
 */
public class TwoSum {

    private static final Logger logger = Logger.getLogger(TwoSum.class.getName());

    /**
     * Finds the indices of the two numbers in the given array that add up to the target.
     *
     * @param nums   The input array of numbers.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers.
     * @throws TwoSumException If no two sum solution is found.
     */
    public int[] twoSum(int[] nums, int target) throws TwoSumException {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                logger.info("Found two numbers at indices " + numMap.get(complement) + " and " + i);
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(nums[i], i);
        }
        logger.severe("No two sum solution found");
        throw new TwoSumException("No two sum solution");
    }

    /**
     * This custom exception is thrown when no two sum solution is found.
     */
    public class TwoSumException extends Exception {


        public TwoSumException(String message) {
            super(message);
        }
    }
}
