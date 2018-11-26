package recursion;

public class MathOperations {
    /**
     * Task 1: Write a recursive function for calculating factorial of a natural number N
     */
    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else if (num > 1) {
            return num * factorial(num - 1);
        } else {
            throw new IllegalArgumentException("wrong input");
        }
    }

    /**
     * Task 2: Write a recursive function for calculating power A of a real number N (N - natural number)
     */
    public static int power(int num, int pow) {
        if (num == 0 & pow == 0) {
            return 1;
        } else if (pow == 0) {
            return 1;
        } else if (pow >= 1) {
            return num * power(num, pow - 1);
        } else {
            throw new IllegalArgumentException("wrong input");
        }
    }

    /**
     * Task 3: Write a recursive function for calculating sum of digits of a natural number.
     */
    public static int getSumOfDigits(int num) {
        int ost = num % 10;
        if (num >= 10) {
            return ost + getSumOfDigits(num / 10);
        } else if (num >= 0) {
            return ost;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Task 4: Write a recursive function for calculating amount of digits of a natural number.
     */
    public static int getAmountOfDigits(int num) {
        if (num/10>0){
            return 1+ getAmountOfDigits(num/10);
        } else if (num%10>=0) {
            return 1;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}

