import java.util.Scanner;

public class MinMax {
	public static void main(String args[]) {
        int nums[] = new int[5];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 5 integers: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("Integer #%d: ", i + 1);
            nums[i] = scan.nextInt();
        }
        int minimum = min(nums);
        int maximum = max(nums);
        System.out.printf("The minimum value in the array is: %d\n", minimum);
        System.out.printf("The maximum value in the array is: %d\n", maximum);
        System.out.printf("The sum of max and min values in the array is: %d\n", minimum + maximum);
        System.out.printf("The average of max and min values in the array is: %f\n", (minimum + maximum) / 2.0f);
	}

    public static int min(int arr[]) {
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= temp)
                temp = arr[i];
        }
        return temp;
    }

    
    public static int max(int arr[]) { 
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= temp)
                temp = arr[i];
        }
        return temp;
    }

}
