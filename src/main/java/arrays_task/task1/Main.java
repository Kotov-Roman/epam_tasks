package arrays_task.task1;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {};
        System.out.println(arr.length);
        FourCorners fourCorners = new FourCorners();
        fourCorners.setArr(arr);
        System.out.println(fourCorners.printFourCorners());

    }
}
