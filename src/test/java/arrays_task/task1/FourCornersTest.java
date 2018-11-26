package arrays_task.task1;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourCornersTest {
    private static FourCorners fourCorners = new FourCorners();

    @Test
    public void testPrintFourCorners1() {
        String[][] arr = {
                {"10", "20", "30"},
                {"10", "20", "30"},
                {"40", null}};
        fourCorners.setArr(arr);
        assertEquals("103040", fourCorners.printFourCorners());
    }

    @Test
    public void testPrintFourCorners2() {
        String[][] arr = {
                {"10", "20", "30"},
                {"10", "20", "30"},
                {"40", "50"}};
        fourCorners.setArr(arr);
        assertEquals("10304050", fourCorners.printFourCorners());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintFourCorners3() {
        String[][] arr = {
                {"10", "20", "30"},
                {"10", "20", "30"},
                {}};
        fourCorners.setArr(arr);
        fourCorners.printFourCorners();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPrintFourCorners4() {
        String[][] arr = {};
        fourCorners.setArr(arr);
        fourCorners.printFourCorners();
    }
}