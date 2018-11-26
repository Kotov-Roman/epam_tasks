package arrays_task.task1;

import com.sun.istack.internal.NotNull;
import sun.rmi.runtime.NewThreadAction;

import java.util.Arrays;

public class FourCorners {
    private String[][] arr = {
            {"00", "01", "02"},
            {"10", "11", "12"}};

    /**
     * @return String which is sum result of symbols from 4 corners of array
     */
    public String printFourCorners() {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length < 2) {
                throw new IllegalArgumentException("Array should have more that 2 elements with each length more then 2 symbols ");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arr[0][0]);
        stringBuilder.append(arr[0][arr[0].length - 1]);
        stringBuilder.append(arr[arr.length - 1][0]);
        stringBuilder.append(arr[arr.length - 1][arr[arr.length - 1].length - 1]);
        return stringBuilder.toString();
    }

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }
}
