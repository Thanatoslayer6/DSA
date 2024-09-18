import java.util.Scanner;

public class lbRecActOne_Labadan {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\t========== STRING LENGTH RECURSION ==========\n");
		System.out.print("\t Enter a string: ");
		String userInput = scan.nextLine();
		System.out.printf("\t The length is: %d\n\n", getStringLength(userInput));
		System.out.println("\t=============================================\n");
	}

	public static int getStringLength(String str) {
		// Base case: if the string is empty its length is 0, or if we reach the end of the string
		if (str.equals("")) return 0;
		// Recursive case: remove the first character using `substring` and find the length of the remaining string
        return getStringLength(str.substring(1)) + 1;
	}
}