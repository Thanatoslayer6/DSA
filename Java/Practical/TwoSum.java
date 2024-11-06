import java.util.Scanner;
import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.printf("Enter element #%d: ", i + 1);
			arr[i] = scan.nextInt();
		}
		System.out.print("Enter target: ");
		int target = scan.nextInt();

		// Bruteforce...
		System.out.println("Solution: " + Arrays.toString(twoSumBruteForce(arr, target)));
		// HashMap...
		System.out.println("Solution: " + Arrays.toString(twoSumHashMap(arr, target)));
	}

	// Solution #1: Using Bruteforce method... O(n^2)
	public static int[] twoSumBruteForce(int nums[], int target) {
		for (int i = 0; i < nums.length; i++) { // Loop at n - 1
			for (int j = i + 1; j < nums.length; j++) { // Loop at n
				if (nums[i] + nums[j] == target) {
					return new int[]{ i, j };
				}
			}
		}
		return new int[]{};
	}
	// Solution #2 Using One-way Hashmap method... O(n)
	// {5, 2, 4} => 6
	public static int[] twoSumHashMap(int nums[], int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			// First calculate the complement
			int complement = target - nums[i];
			// First check if the element exists in the HashMap, if it does it means we've solved it...
			if (map.containsKey(complement)) {
				return new int[]{i, map.get(complement) };
			}
			// Else just add the complement as key...
			map.put(complement, i);
		}
		return new int[]{};
	}
}