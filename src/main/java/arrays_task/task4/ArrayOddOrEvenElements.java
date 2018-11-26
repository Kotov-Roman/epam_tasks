package arrays_task.task4;

public class ArrayOddOrEvenElements {
    private String[][] arr = {
            {"00", "01", "02", "03", "04"},
            {"10", "11", "12", "13", "14"},
            {"20", "21", "22", "23", "24"},
            {"30", "31", "32", "33", "34"},
            {"40", "41", "42", "43", "44"}};

    /**
     * /** Method returns string which consist of sequince elements with even index from each element of array
     *
     * @return string result
     */
    public String printEvenElementsStrings() {
        //Array is not empty check
        if (checkNotNullOrEmpty()) {
            throw new IllegalArgumentException("array should not be empty");
        }
        //length element check
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null ||arr[i].length == 0) {
                throw new IllegalArgumentException("Array should not have empty elements ");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int stringIndex = 0; stringIndex < arr.length; stringIndex++) {
            for (int elementIndex = 0; elementIndex < arr[stringIndex].length; elementIndex++) {
                if (elementIndex % 2 == 0) {
                    stringBuilder.append(arr[stringIndex][elementIndex]);
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * /** Method returns string which consist of sequince elements with odd index from each element of array
     *
     * @return string result
     */
    public String printOddElementsColumn() {
        if (checkNotNullOrEmpty()) {
            throw new IllegalArgumentException("array should not be empty");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null ||arr[i].length == 0) {
                throw new IllegalArgumentException("Array should not have empty elements ");
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].length != arr[i + 1].length) {
                throw new IllegalArgumentException("Array should have equals lengths in elements ");
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int stringIndex = 0; stringIndex < arr.length; stringIndex++) {
            for (int columnIndex = 0; columnIndex < arr.length; columnIndex++) {
                if (columnIndex % 2 != 0) {
                    stringBuilder.append(arr[columnIndex][stringIndex]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public boolean checkNotNullOrEmpty(){
        if (arr == null ||arr.length == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public String[][] getArr() {
        return arr;
    }

    public void setArr(String[][] arr) {
        this.arr = arr;
    }
}
