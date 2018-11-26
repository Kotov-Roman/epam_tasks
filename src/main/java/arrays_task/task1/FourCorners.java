package arrays_task.task1;

public class FourCorners {
    private String[][] arr;

    public String printFourCorners() {
    if (arr.length == 0) {
        throw new IllegalArgumentException("array should not be empty");
    }
    //length check
        for (String[] anArr : arr) {
            if (anArr.length < 2) {
                throw new IllegalArgumentException("Array should have more that 2 elements with each length more then 2 symbols ");
            }
        }
    StringBuilder stringBuilder = new StringBuilder();
    //append 1st corner
    if (arr[0][0] != null) {
        stringBuilder.append(arr[0][0]);
    }
    //append 2nd corner
    if (arr[0][arr[0].length - 1] != null) {
        stringBuilder.append(arr[0][arr[0].length - 1]);
    }
    //append 3th corner
    if (arr[arr.length - 1][0] != null) {
        stringBuilder.append(arr[arr.length - 1][0]);
    }
    //append 4th corner
    if (arr[arr.length - 1][arr[arr.length - 1].length - 1] != null) {
        stringBuilder.append(arr[arr.length - 1][arr[arr.length - 1].length - 1]);
    }
    return stringBuilder.toString();
}

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }
}
