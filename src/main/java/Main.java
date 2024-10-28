import com.rimdome.dsa.leet1.PalindromeNumber;

import com.rimdome.dsa.leet1.RomanToIntegerConverter;
import com.rimdome.dsa.leet1.TwoSum;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Leet problems");





        // Example usage of RomanToInteger class
        RomanToIntegerConverter romanToInteger = new RomanToIntegerConverter();

        int result = 0;
        try {
            result = romanToInteger.convert("MCMXCIV");
        } catch (RomanToIntegerConverter.InvalidRomanNumeralException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Converted value: " + result);


	/*
        // Example usage of TwoSum class
	        TwoSum twoSum = new TwoSum();
	        int[] nums = {2, 7, 11, 15};
	        int target = 9;
        try {
            int[] result = twoSum.twoSum(nums, target);
            System.out.println("Indices of the two numbers that add up to target: " + result[0] + ", " + result[1]);
        } catch (TwoSum.TwoSumException e) {
            throw new RuntimeException(e);
        }
	*/

	/*
        // Example usage of PalindromeNumber class
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        try {
            palindromeNumber.isPalindrome(121);
        } catch (PalindromeNumber.InvalidInputException e) {
            throw new RuntimeException(e);
        }

	*/

    }
}
