import java.util.Scanner;

public class ReverseString {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a string to be reversed: ");
        String s = scan.nextLine();
        System.out.printf("The string in reverse is: %s\n", reverseString(s));
    }

    public static String reverseString(String input) {
        if (input.isEmpty()) { // Base case
            return input;
        }
        // Hello                                      01234
        // ello + H                                  "Hello"
        // llo + e + H
        // lo + l + e + H
        // o + l + l + e + H
        return reverseString(input.substring(1)) + input.charAt(0);
                                                  //   "H"
                                                  //
        // "Hello".substring(0, 2)
        // "He"
        // "Hello".substring(0, 3)
        // "Hel"
        // "Hello".substring(1);
        // "ello"
    }
}
