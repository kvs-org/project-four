package com.kvs.division.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link DivisionService} class.
 * 
 * This test class verifies the behavior of the division functionality provided
 * by the DivisionService. It includes tests for valid division, division by zero,
 * handling of negative numbers, and cases where the result is a decimal value.
 */
public class DivisionServiceTest {

    private final DivisionService divisionService = new DivisionService();

    @Test
    public void testValidDivision() {
        // Test valid division
        double result = divisionService.divide(10, 2);
        assertEquals(5.0, result, "10 divided by 2 should be 5.0");
    }

    @Test
    public void testDivisionByZero() {
        // Test division by zero
        assertThrows(ArithmeticException.class, () -> divisionService.divide(10, 0), "Division by zero should throw ArithmeticException");
    }

    @Test
    public void testNegativeNumbers() {
        // Test division with negative numbers
        double result = divisionService.divide(-10, 2);
        assertEquals(-5.0, result, "-10 divided by 2 should be -5.0");
    }

    @Test
    public void testDecimalResult() {
        // Test division resulting in a decimal value
        double result = divisionService.divide(7, 2);
        assertEquals(3.5, result, "7 divided by 2 should be 3.5");
    }
}