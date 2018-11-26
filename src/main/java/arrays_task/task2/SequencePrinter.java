package arrays_task.task2;

public class SequencePrinter {
    private String[][] arr ={
        {"00", "01", "02", "03", "04"},
        {"10", "11", "12", "13", "14"},
        {"20", "21", "22", "23", "24"},
        {"30", "31", "32", "33", "34"},
        {"40", "41", "42", "43", "44"}};

    public String PrintSequence(int targetArrayIndex, int startIndex, int endInedex) {
        //Array is not empty check
        if (arr.length == 0) {
            throw new IllegalArgumentException("array should not be empty");
        }
        //length element check
        for (String[] anArr : arr) {
            if (anArr.length == 0) {
                throw new IllegalArgumentException("Array should not have empty elements ");
            }
        }
        //input check
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

