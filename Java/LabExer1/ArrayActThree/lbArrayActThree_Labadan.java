import java.util.Scanner;
import java.util.Arrays;

public class lbArrayActThree_Labadan {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {
        String response;
        float[] arr = new float[10];
        fillArrayUserInput(arr); // Ask user to fill array with 10 floats

        do {
            printArray(arr);
            // Search for the element
            System.out.print(" ~ Enter value of element to remove: ");
            float elementToRemove = scan.nextFloat();

            // Find the element using linear search if it exists
            int indexOfElementToRemove = searchForElement(arr, elementToRemove);

            if (indexOfElementToRemove == -1) {
                System.out.println(" ~ NOT FOUND! ~");
                System.out.print("\n ~ Do you wish to continue? (YES/NO): ");
                scan.nextLine(); // Clear newline input buffer
                response = scan.nextLine();
                continue;
            }

            System.out.println(" ~ FOUND! ~");

            // Create a new array with length - 1
            float[] temp_arr = new float[arr.length - 1];
            copyArrayExcept(arr, temp_arr, indexOfElementToRemove);
            arr = null; // Clear out the original array
            arr = temp_arr; // Reassign the original array with newly created array

            printArray(arr);

            System.out.print(" ~ Do you wish to continue? (YES/NO): ");
            scan.nextLine(); // Clear newline input buffer
            response = scan.nextLine();

        } while (response.equalsIgnoreCase("YES"));

        System.out.println(" ~ Exiting program...");
    }

    public static void fillArrayUserInput(float array[]) {
        System.out.println(" ~ Enter 10 floating point values: ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("  - Value #%d: ", i + 1);
            array[i] = scan.nextFloat();
        }
    }

    public static void printArray(float array[]) {
		// If array is empty stop the program
		if (array.length == 0) {
			System.out.println("\n ~ Array is now empty, exiting the program...");
			System.exit(0);
		}
        System.out.println("\n ~ Contents of array: " + Arrays.toString(array));
    }

    // Method will search for the element in linear time, returns `-1` if not found
    public static int searchForElement(float array[], float elementToFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToFind)
                return i;
        }
        return -1;
    }

    // Method will copy the elements of source into destination, except for the element that is passed
    public static void copyArrayExcept(float sourceArray[], float destinationArray[], int indexOfElement) {
        for (int srcIterator = 0, destIterator = 0; srcIterator < sourceArray.length; srcIterator++) {
            if (srcIterator == indexOfElement) {
                if (srcIterator == sourceArray.length - 1) // If last element simply exit
                    break;
                srcIterator++; // Skip the element by incrementing the iterator
            }
            // Copy the element into destinationArray
            destinationArray[destIterator] = sourceArray[srcIterator];
            destIterator++;
        }
    }
}