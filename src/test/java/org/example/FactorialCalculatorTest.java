package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0));
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.factorial(5));
        assertEquals(720, FactorialCalculator.factorial(6));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1));
    }

    @Test
    void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
        assertEquals("Number must be non-negative", exception.getMessage());
    }
}
