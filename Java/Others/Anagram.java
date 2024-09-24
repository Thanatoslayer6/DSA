import java.util.Scanner;

public class Anagram {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String myString = scan.nextLine();

		anagram(myString, 0, myString.length() - 1);

	}

	public static String swap(String s, int index1, int index2) {
		char arr[] = s.toCharArray(); // kunyari, "ABC", 0, 2
		char temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		return new String(arr);
	}

	public static void anagram(String input, int currentIndex, int lastIndex) {
		if (currentIndex == lastIndex) {
			System.out.println(input);
			return;
		}

		for (int i = currentIndex; i <= lastIndex; i++) {
			anagram(swap(input, currentIndex, i), currentIndex + 1, lastIndex);
		}

	}

	// ABC
	//   BC
	//    C

	/*
	public static void anagram_iterative(String input) {
		// ABC
		char remainingChars[] = new char[input.length() - 1]; // BC, CB
		for (int i = 0; i < input.length(); i++) {
			for (int k = 0, iterator = 0; k < input.length(); k++) {
				if (i == k)
					continue;
				remainingChars[iterator] = input.charAt(k);
				iterator++;
			}
			System.out.println(input.charAt(i) + remainingChars);
			System.out.println(input.charAt(i) + reverseString((remainingChars)));
			remainingChars = new char[input.length() - 1];
		}
	}
	*/

	// Para magreverse yung string
	public static String reverseString(String input) {
		char[] reversedString = new char[input.length()]; // Gawa ng char array na may same size na empty
		for (int i = 0; i < input.length(); i++) { // Iterate over the string 0 -> n
			reversedString[i] = input.charAt(input.length() - 1 - i);
		}
		return String.copyValueOf(reversedString);
	}

	// Recursive way to reverse a string phew.....
	public static String reverseStringRecursive(String input) {

		int lastCharIndex = input.length() - 1;
		String lastChar = input.charAt(lastCharIndex) + "";
		if (lastCharIndex == 0) {
			return lastChar;
		}

		return lastChar.concat(reverseStringRecursive(input.substring(0, input.length() - 1)));
	}
}
