package com.rimdome.dsa.leet1;

import java.util.logging.Logger;

/**
 * This class provides a method to check if a given integer is a palindrome.
 *
 * @author Rimmy Uddin.
 * @version 1.0
 */
public class PalindromeNumber {

    private static final Logger logger = Logger.getLogger(PalindromeNumber.class.getName());

    /**
     * Checks if the given integer is a palindrome.
     *
     * @param x the integer to check
     * @return true if the integer is a palindrome, false otherwise
     * @throws InvalidInputException if the input is negative
     */
    public boolean isPalindrome(int x) throws InvalidInputException {
        logger.info("Checking if " + x + " is a palindrome.");

        if (x < 0) {
            throw new InvalidInputException("Negative numbers are not considered palindromes.");
        }

        int original = x;
        int reversed = 0;

        while (original != 0) {
            int digit = original % 10;
            reversed = reversed * 10 + digit;
            original /= 10;
        }

        boolean result = x == reversed;
        logger.info("Result: " + result);
        return result;
    }

    /**
     * Custom exception for invalid input.
     */
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}