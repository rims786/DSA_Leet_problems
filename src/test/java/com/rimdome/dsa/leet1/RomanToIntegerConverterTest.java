package com.rimdome.dsa.leet1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the RomanToIntegerConverter class.
 * This class tests the conversion of Roman numerals to integers,
 * including both valid and invalid cases.
 */
public class RomanToIntegerConverterTest {

    private final RomanToIntegerConverter converter = new RomanToIntegerConverter();

    /**
     * Test valid Roman numeral conversions.
     * This test verifies that the convert method correctly translates
     * valid Roman numerals to their respective integer values.
     */
    @Test
    public void testValidConversions() throws RomanToIntegerConverter.InvalidRomanNumeralException {
        assertEquals(3, converter.convert("III"), "Expected value for 'III' is 3");
        assertEquals(4, converter.convert("IV"), "Expected value for 'IV' is 4");
        assertEquals(9, converter.convert("IX"), "Expected value for 'IX' is 9");
        assertEquals(58, converter.convert("LVIII"), "Expected value for 'LVIII' is 58");
        assertEquals(1994, converter.convert("MCMXCIV"), "Expected value for 'MCMXCIV' is 1994");
    }

    /**
     * Test invalid Roman numeral conversions.
     * This test verifies that the convert method throws the appropriate
     * exception when invalid Roman numeral strings are passed as input.
     */
    @Test
    public void testInvalidConversions() {
        // Invalid cases that should throw exceptions
        assertThrows(RomanToIntegerConverter.InvalidRomanNumeralException.class,
                () -> converter.convert("IIII"),
                "Expected exception for 'IIII'");
        assertThrows(RomanToIntegerConverter.InvalidRomanNumeralException.class,
                () -> converter.convert("ABC"),
                "Expected exception for 'ABC'");
        assertThrows(RomanToIntegerConverter.InvalidRomanNumeralException.class,
                () -> converter.convert(""),
                "Expected exception for empty string");
        assertThrows(RomanToIntegerConverter.InvalidRomanNumeralException.class,
                () -> converter.convert(null),
                "Expected exception for null input");
    }
}
