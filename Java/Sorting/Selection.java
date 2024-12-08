import java.util.Arrays;

public class Selection {
    public static void main(String args[]) {
        int numbers[] = {40, 12, 23, 15, 2, 1, 8};
        System.out.println("BEFORE : " + Arrays.toString(numbers));
        selectionSort(numbers);
        System.out.println("AFTER  : " + Arrays.toString(numbers));
    }

    public static void selectionSort(int nums[]) {
        for (int i = 0; i < nums.length - 1; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[indexOfMin]) {
                    indexOfMin = j;
                }
            }
            // Swap
            int temp = nums[i];
            nums[i] = nums[indexOfMin];
            nums[indexOfMin] = temp;
        }
    }
}
