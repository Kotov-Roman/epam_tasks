package arrays_task.task3;

public class Main {
    public static void main(String[] args) {
        Array5x5 array5x5 = new Array5x5();
        String [][]arr = {
                {"00", "01", "02", "03", "04"},
                {"10", "11", "12", "13", "14"},
                {"20", "21", "22", "23", "24"},
                {"30", "31", "32", "33", "34"},
                {"40", "41", "42", "43", "44"}};
        System.out.println(array5x5.printLeftToRight());
        System.out.println(array5x5.printUpToDown());
    }
}
