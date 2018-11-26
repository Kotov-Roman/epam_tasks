package arrays_task.task2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequencePrinterTest {
    private static SequencePrinter sequencePrinter = new SequencePrinter();

    @Test
    public void testPrintSequence1() {
        String[][] arr = {
                {"10", "20", "30"},
                {"10", "20", "30"},
                {"40", "50"}};
        sequencePrinter.setArr(arr);
        assertEquals("102030", sequencePrinter.PrintSequence(1, 0, 2));
    }
    @Test
    public void testPrintSequence2() {
        String[][] arr = {
                {"10", "20", "30"},
                {"10", "20", "30"},
                {"40", "50"}};
        sequencePrinter.setArr(arr);
        assertEquals("10", sequencePrinter.PrintSequence(0, 0, 0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPrintSequence3() {
        String[][] arr = {
                {},
                {"10", "20", "30"},
                {"40", "50"}};
        sequencePrinter.setArr(arr);
       sequencePrinter.PrintSequence(0, 0, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testPrintSequence4() {
        String[][] arr = {};
        sequencePrinter.setArr(arr);
       sequencePrinter.PrintSequence(0, 0, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintSequence5() {
        String[][] arr =  {
                {"10", "20", "30"},
                {"10", "20", "30"},
                {"40", "50"}};
        sequencePrinter.setArr(arr);
        sequencePrinter.PrintSequence(0, 0, 10);
    }
}