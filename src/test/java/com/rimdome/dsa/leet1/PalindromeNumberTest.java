package com.rimdome.dsa.leet1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class PalindromeNumberTest {

    @Test
    public void testIsPalindrome() throws PalindromeNumber.InvalidInputException {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        // Positive test cases
        assertTrue(palindromeNumber.isPalindrome(121)); // Palindrome number
        assertTrue(palindromeNumber.isPalindrome(0));   // Single digit palindrome
        assertTrue(palindromeNumber.isPalindrome(1221)); // Even length palindrome
        assertTrue(palindromeNumber.isPalindrome(12321)); // Odd length palindrome

        // Negative test cases
        assertFalse(palindromeNumber.isPalindrome(123)); // Not a palindrome
        assertFalse(palindromeNumber.isPalindrome(10));  // Not a palindrome
        assertFalse(palindromeNumber.isPalindrome(123456)); // Not a palindrome
    }

    @Test
    public void testNegativeNumbers() {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        // Negative numbers should throw InvalidInputException
        assertThrows(PalindromeNumber.InvalidInputException.class, () -> {
            palindromeNumber.isPalindrome(-121);
        });
        assertThrows(PalindromeNumber.InvalidInputException.class, () -> {
            palindromeNumber.isPalindrome(-1);
        });
    }

    @Test
    public void testEdgeCases() throws PalindromeNumber.InvalidInputException {
        PalindromeNumber palindromeNumber = new PalindromeNumber();

        // Edge cases
        assertTrue(palindromeNumber.isPalindrome(1)); // Single digit
        assertTrue(palindromeNumber.isPalindrome(11)); // Two same digits
        assertFalse(palindromeNumber.isPalindrome(1000021)); // Large non-palindrome
    }
}
