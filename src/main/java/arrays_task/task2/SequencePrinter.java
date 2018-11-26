package arrays_task.task2;

public class SequencePrinter {
    private String[][] arr ={
        {"00", "01", "02", "03", "04"},
        {"10", "11", "12", "13", "14"},
        {"20", "21", "22", "23", "24"},
        {"30", "31", "32", "33", "34"},
        {"40", "41", "42", "43", "44"}};

    /** Method returns sequence elements of array from specified start index inclusive to
     * specified last index inclusive at specified element of array.
     * @param targetArrayIndex
     * @param startIndex
     * @param endInedex
     * @return  the specified substring
     */
    public String PrintSequence(int targetArrayIndex, int startIndex, int endInedex) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null || arr[i].length ==0) {
                throw new IllegalArgumentException("Array should not have empty elements ");
            }
        }
        if (startIndex > endInedex || targetArrayIndex > arr.length - 1) {
            throw new IllegalArgumentException("Wrong  input");
        }
        if (endInedex > arr[targetArrayIndex].length -1){
            throw new IllegalArgumentException("target array should be longer ");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = startIndex; index <=endInedex; index++){
            stringBuilder.append(arr[targetArrayIndex][index]);
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

