package arrays_task.task2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1", "2"},{}};
        SequencePrinter printer = new SequencePrinter();
        printer.setArr(arr);
        System.out.println(printer.PrintSequence(0, 0, 1));

    }
}
