package arrays_task.task3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Array5x5Test {
    private static Array5x5 array5x5 = new Array5x5();

    @Test
    public void testPrintLeftToRight1() {
        String[][] arr = {
                {"00", "01", "02", "03", "04"},
                {"10", "11", "12", "13", "14"},
                {"20", "21", "22", "23", "24"},
                {"30", "31", "32", "33", "34"},
                {"40", "41", "42", "43", "44"}};
        array5x5.setArr(arr);
        assertEquals("00020411132022243133404244", array5x5.printLeftToRight());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintLeftToRight2() {
        String[][] arr = {
                {},
                {"10", "11", "12", "13", "14"},
                {"20", "21", "22", "23", "24"},
                {"30", "31", "32", "33", "34"},
                {"40", "41", "42", "43", "44"}};
        array5x5.setArr(arr);
        array5x5.printLeftToRight();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintLeftToRight3() {
        String[][] arr = {};
        array5x5.setArr(arr);
        array5x5.printLeftToRight();
    }

    @Test
    public void testPrintUpToDown1() {
        String[][] arr = {
                {"00", "01", "02", "03", "04"},
                {"10", "11", "12", "13", "14"},
                {"20", "21", "22", "23", "24"},
                {"30", "31", "32", "33", "34"},
                {"40", "41", "42", "43", "44"}};
        array5x5.setArr(arr);
        assertEquals("00204011310222421333042444", array5x5.printUpToDown());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintUpToDown2() {
        String[][] arr = {
                {},
                {"10", "11", "12", "13", "14"},
                {"20", "21", "22", "23", "24"},
                {"30", "31", "32", "33", "34"},
                {"40", "41", "42", "43", "44"}};
        array5x5.setArr(arr);
        array5x5.printUpToDown();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintUpToDown3() {
        String[][] arr = {};
        array5x5.setArr(arr);
        array5x5.printUpToDown();
    }
}