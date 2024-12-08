import java.util.Arrays;

public class Bubble {
    public static void main(String args[]) {
        int numbers[] = {2, 8, 21, 4, 1, 12};
        System.out.println("BEFORE : " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("AFTER  : " + Arrays.toString(numbers));
    }

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    // Swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
