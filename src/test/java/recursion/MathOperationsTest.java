package recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class MathOperationsTest {

    @Test
    public void testFactorial() {
        assertEquals(120,MathOperations.factorial(5));
        assertEquals(1,MathOperations.factorial(0));
        assertEquals(1,MathOperations.factorial(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial2() {
        assertEquals(120, MathOperations.factorial(-5));

    }

    @Test
    public void testPower() {
        assertEquals(3125, MathOperations.power(5,5));
        assertEquals(1, MathOperations.power(1,0));
        assertEquals(0, MathOperations.power(0,1));
        assertEquals(10, MathOperations.power(10,1));
        assertEquals(1, MathOperations.power(1,10));
        assertEquals(0, MathOperations.power(0,10));
        assertEquals(1, MathOperations.power(0,0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPower2() {
        assertEquals(3125, MathOperations.power(5,-1));
        assertEquals(3125, MathOperations.power(-5,-1));
        assertEquals(3125, MathOperations.power(-5,1));
    }

    @Test
    public void testGetSumOfDigits() {
        assertEquals(15, MathOperations.getSumOfDigits(12345));
        assertEquals(0, MathOperations.getSumOfDigits(0));
        assertEquals(1, MathOperations.getSumOfDigits(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSumOfDigits2() {
        assertEquals(15, MathOperations.getSumOfDigits(-10));
    }

    @Test
    public void testGetAmountOfDigits() {
        assertEquals(5, MathOperations.getAmountOfDigits(12345));
        assertEquals(1, MathOperations.getAmountOfDigits(0));
        assertEquals(1, MathOperations.getAmountOfDigits(5));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetAmountOfDigits2() {
        assertEquals(5, MathOperations.getAmountOfDigits(-5));

    }
}