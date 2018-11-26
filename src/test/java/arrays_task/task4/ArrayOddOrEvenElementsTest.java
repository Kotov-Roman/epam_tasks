package arrays_task.task4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayOddOrEvenElementsTest {
    private static ArrayOddOrEvenElements arrayOddOrEvenElements = new ArrayOddOrEvenElements();

    @Test
    public void testPrintEvenElementsStrings1() {
        String[][] arr = {
                {"00", "01", "02"},
                {"10", "11", "12"},
                {"20", "21", "22"}};
        arrayOddOrEvenElements.setArr(arr);
        assertEquals("000210122022", arrayOddOrEvenElements.printEvenElementsStrings());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintEvenElementsStrings2() {
        String[][] arr = {
                {},
                {"10", "11", "12"},
                {"20", "21", "22"}};
        arrayOddOrEvenElements.setArr(arr);
        arrayOddOrEvenElements.printEvenElementsStrings();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintEvenElementsStrings3() {
        String[][] arr = {};
        arrayOddOrEvenElements.setArr(arr);
        arrayOddOrEvenElements.printEvenElementsStrings();
    }

    @Test
    public void testPrintOddElementsColumn1() {
        String[][] arr = {
                {"00", "01", "02"},
                {"10", "11", "12"},
                {"20", "21", "22"}};
        arrayOddOrEvenElements.setArr(arr);
        assertEquals("101112", arrayOddOrEvenElements.printOddElementsColumn());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintOddElementsColumn2() {
        String[][] arr = {
                {"00", "01", "02"},
                {"10", "11", "12"},
                {"20", "21"}};
        arrayOddOrEvenElements.setArr(arr);
        assertEquals("101112", arrayOddOrEvenElements.printOddElementsColumn());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintOddElementsColumn3() {
        String[][] arr = {
                {},
                {"10", "11", "12"},
                {"20", "21", "22"}};
        arrayOddOrEvenElements.setArr(arr);
        arrayOddOrEvenElements.printEvenElementsStrings();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintOddElementsColumn4() {
        String[][] arr = {};
        arrayOddOrEvenElements.setArr(arr);
        arrayOddOrEvenElements.printOddElementsColumn();
    }

}