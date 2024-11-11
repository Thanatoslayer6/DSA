import java.util.Arrays;
import java.util.Scanner;

public class BSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of int array: ");
        int n = scan.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter element #%d: ", i + 1);
            arr[i] = scan.nextInt();
        }
        System.out.print("What number to find?: ");
        int toFind = scan.nextInt();

        int answer = search(arr, toFind);
        System.out.println("Array is: " + Arrays.toString(arr));
        System.out.printf("Answer is in index: %d", answer);
    }

    static int search(int arr[], int target) {
        return helper(arr, 0, arr.length - 1, target);
    }

    static int helper(int arr[], int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        // Divide the array by 2, get the middle
        int mid = (int)((r + l)/ 2);
        if (arr[mid] == target) {
            return mid;    
        } 
        
        // Search right
        if (arr[mid] < target) {
            return helper(arr, mid + 1, r, target);
        }
        // Search left
        return helper(arr, l, mid - 1, target);
    }
}
