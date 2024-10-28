package com.rimdome.dsa.leet1;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * A thread-safe class to convert Roman numerals to integers.
 */
public class RomanToIntegerConverter {
    private static final Logger logger = Logger.getLogger(RomanToIntegerConverter.class.getName());
    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    /**
     * Converts a Roman numeral to an integer.
     *
     * @param roman the Roman numeral as a string
     * @return the integer value of the Roman numeral
     * @throws InvalidRomanNumeralException if the Roman numeral is invalid
     */
    public synchronized int convert(String roman) throws InvalidRomanNumeralException {
        if (roman == null || roman.isEmpty()) {
            logger.log(Level.SEVERE, "Input is null or empty");
            throw new InvalidRomanNumeralException("Input cannot be null or empty");
        }

        int total = 0;
        int prevValue = 0;

        // Keep track of consecutive characters
        int consecutiveCount = 1;

        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);
            Integer currentValue = romanMap.get(ch);

            if (currentValue == null) {
                logger.log(Level.SEVERE, "Invalid Roman numeral character: {0}", ch);
                throw new InvalidRomanNumeralException("Invalid Roman numeral: " + ch);
            }

            // Check for the subtractive notation
            if (currentValue > prevValue) {
                total += currentValue - 2 * prevValue; // adjust for previously added value
                consecutiveCount = 1; // reset count for subtractive cases
            } else {
                total += currentValue;
                // Check for invalid consecutive characters (like 'IIII')
                if (currentValue == prevValue) {
                    consecutiveCount++;
                    if ((prevValue == 1 && consecutiveCount > 3) ||
                            (prevValue == 10 && consecutiveCount > 3) ||
                            (prevValue == 100 && consecutiveCount > 3)) {
                        logger.log(Level.SEVERE, "Invalid consecutive characters: {0}", roman);
                        throw new InvalidRomanNumeralException("Invalid Roman numeral: " + roman);
                    }
                } else {
                    consecutiveCount = 1; // reset for different characters
                }
            }
            prevValue = currentValue;
        }

        logger.log(Level.INFO, "Converted Roman numeral: {0} to integer: {1}", new Object[]{roman, total});
        return total;
    }

    /**
     * Custom exception for handling invalid Roman numeral inputs.
     */
    public class InvalidRomanNumeralException extends Exception {
        public InvalidRomanNumeralException(String message) {
            super(message);
        }
    }

}

