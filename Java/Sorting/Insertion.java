import java.util.Arrays;

public class Insertion {
    public static void main(String args[]) { 
        int numbers[] = {2, 8, 21, 4, 1, 12, 100, 204};
        System.out.println("BEFORE : " + Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println("AFTER  : " + Arrays.toString(numbers));
    }

    public static void insertionSort(int nums[]) {
        for (int i = 1; i < nums.length; i++) {
            int currentValue = nums[i];
            // Examine elements to the left
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > currentValue) {
                    // Shift those elements to the right if they are larger
                    nums[j + 1] = nums[j];
                    nums[j] = currentValue;
                } else {
                    break;
                }
            }
        }
    }
}
