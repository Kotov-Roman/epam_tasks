package strings;

public class Task2 {
    /* 9.13. Given a word. Display third symbol.
     * 9.14. Given a word. Display last symbol.
     * 9.15. Given a word. Display symbol at number k.
     * 9.64. Given a sentence. Determine how many identical symbols there are in it.
     * 9.100. Given a word. Swap it's second and fifth parts.
     */
    public static char getThirdChar(String string) {
        if (string == null || string.length() < 3) {
            throw new IllegalArgumentException("Illegal argument");
        } else {
            return string.charAt(2);
        }
    }

    public static char getLastChar(String string) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException("Illegal argument");
        } else {
            return string.charAt(string.length() - 1);
        }
    }

    public static char getTargetChar(String string, int target) {
        if (string == null || string.length() < target) {
            throw new IllegalArgumentException("Illegal argument");
        } else {
            return string.charAt(target - 1);
        }
    }

    public static int getSummOfEqualsChars(String string) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException("Illegal argument");
        } else {
            int count = 0;
            int sum = 0;
            for (int i = 0; i < string.length() - 1; i++) {
                if (string.charAt(i) == string.charAt(i + 1)) {
                    count++;
                } else if (string.charAt(i) != string.charAt(i + 1) && count > 0) {
                    sum = sum + 1 + count;
                    count = 0;
                }
            }
            if (count != 0) {
                sum = sum + 1 + count;
            }
            return sum;
        }
    }

    public static String swapSecondAndFifth(String string) {
        if (string == null || string.length() < 5) {
            throw new IllegalArgumentException("Illegal argument");
        } else {
            char[] chars = string.toCharArray();
            char temp = chars[1];
            chars[1] = chars[4];
            chars[4] = temp;
            return String.copyValueOf(chars);
        }
    }

    public static String reverse(String string) {
        if (string == null || string.length() == 0) {
            throw new IllegalArgumentException("Illegal argument");
        } else {
            char[] chars = string.toCharArray();
            char[] result = new char[chars.length];
            int resultIndex = 0;
            for (int i = chars.length - 1; i >= 0; i--) {
                result[resultIndex] = chars[i];
                resultIndex++;
            }
            return String.copyValueOf(result);
        }
    }
}
