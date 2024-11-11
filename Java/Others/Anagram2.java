import java.util.Scanner;

public class Anagram2 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = scan.next();
		anagram(word);
	}

	static void anagram(String word) {
		char[] wordArr = word.toCharArray();
		helper(wordArr, 0);
	}
	
	static void helper(char[] arr, int pos) {
		if (pos == arr.length) {
			System.out.println(String.valueOf(arr));
			return;
		}
		// First turn the word into a Character array
		for (int i = pos; i < arr.length; i++) {

			// Swap the chars, with index i and index pos
			char temp = arr[i]; // 01 this is 0
			arr[i] = arr[pos]; // 11
			arr[pos] = temp; // 10

			helper(arr, pos + 1);

			// Swap back to its original state, because we modified the array
			// This is basically backtracking, because if we don't the positions of the characters would be messed up
			// I mean this step is completely optional however, if you draw the tree it won't be the way it is...
			arr[pos] = arr[i];
			arr[i] = temp;
		}
	}
}
