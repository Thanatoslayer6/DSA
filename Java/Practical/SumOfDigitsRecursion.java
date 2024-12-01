import java.util.Scanner;

public class SumOfDigitsRecursion {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scan.nextInt();
        String numStr = Integer.toString(num);

        System.out.println("The total is: " + sumOfDigits(numStr, 0, 0));
        System.out.println("The total is: " + sumOfDigitsDiff(numStr, 0));
    }

    public static int sumOfDigits(String numStr, int pos, int total) {
        if (numStr.length() == pos)  {
            return total;
        }
        int digit = Character.getNumericValue(numStr.charAt(pos));
        return sumOfDigits(numStr, pos + 1, total + digit);
    }

    public static int sumOfDigitsDiff(String numStr, int pos) {
        if (numStr.length() == pos) {
            return 0;
        }

        int digit = Character.getNumericValue(numStr.charAt(pos));
        return digit + sumOfDigitsDiff(numStr, pos + 1);
    }
}
