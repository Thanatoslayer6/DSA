import java.util.Scanner;
import java.util.Arrays;

public class FlexibleArray {
    public static Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]) {
        System.out.print("Enter size of array: ");
        int n = scan.nextInt();
        int arr[] = inputElementsOfArray(n);
        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Insert element");
            System.out.println("2. Delete element");
            System.out.println("3. Display array");
            System.out.print("Choose an option: ");
            int option = scan.nextInt();
            if (option == 1) {
                System.out.print("Enter element to insert: ");
                int element = scan.nextInt();
                System.out.printf("Enter position within the array [1 - %d]: ", arr.length + 1);
                int position = scan.nextInt();
                arr = insertElementAtPosition(arr, position, element);
            } else if (option == 2) {
                System.out.printf("Enter position to delete within the array [1 - %d]: ", arr.length);
                int position = scan.nextInt();
                arr = deleteElementAtPosition(arr, position);
            } else if (option == 3) {
                System.out.println("The array is: " + Arrays.toString(arr));
            }
        }
    }

    // { 0, 2, 3, 4 } -> 5 at position 1
    // { 5, 0, 2, 3, 4 }
    public static int[] insertElementAtPosition(int arr[], int position, int data) {
        int new_array[] = new int[arr.length + 1];
        for (int i = 0, j = 0; i < new_array.length; i++) {
            if (i == position - 1) {
                new_array[i] = data;
                continue;
            }
            new_array[i] = arr[j];
            j++;
        }
        return new_array;
    }

    public static int[] deleteElementAtPosition(int arr[], int position) {
        int new_array[] = new int[arr.length - 1];
        for (int i = 0, j = 0; i < new_array.length; i++) {
            if (i == position - 1) j++;
            new_array[i] = arr[j];
            j++;
        }
        return new_array;
    }

    public static int[] inputElementsOfArray(int arraySize) {
        int arr[] = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {  
            System.out.printf("Enter element #%d: ", i + 1);
            arr[i] = scan.nextInt();
        }
        return arr;
    }

}
