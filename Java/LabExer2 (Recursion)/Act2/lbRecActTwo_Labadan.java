import java.util.Scanner;
import java.security.KeyStore.SecretKeyEntry;
import java.util.Arrays;

/*
	There are 3 rods, J, O, and Y, with n disks

	    ║      ║      ║
	   ███     ║      ║
	  █████    ║      ║
	 ███████   ║      ║
	════╩══════╩══════╩════
	    J      O      Y

	   STRATEGY:
	   - Move the top 2 disks to rod O using Y
	   - Move largest disk to Y
	   - Move the top 2 disks to rod Y using J

	    ║      ║      ║
	   ███     ║      ║
	  █████    ║      ║
	 ███████   ║      ║
	════╩══════╩══════╩════

	largest disk is (numberOfDisks * 2) + 1 characters wide
*/

class Hanoi {
	int arrayVisualizer[][];
	int numberOfDisks;
	char source, auxiliary, destination;

	public Hanoi(int n, char source, char auxiliary, char destination) {
		this.source = source;
		this.auxiliary = auxiliary;
		this.destination = destination;
		this.numberOfDisks = n;
		this.arrayVisualizer = new int[n][3];
	}

	public void solve() {
		// Fill the array with values, specifically make it so that the data is like this, when there are 3 disks
		/* {1, 0, 0},
		   {2, 0, 0},
		   {3, 0, 0}
		    J  O  Y
		*/
		for (int row = 0; row < arrayVisualizer.length; row++) {
			arrayVisualizer[row][0] = row + 1;
		}
		System.out.println(" HOW IT LOOKS: ");
		displayArray();
        displayASCII();
		System.out.println();
		solve_recursion(numberOfDisks, source, auxiliary, destination);

	}

	public void solve_recursion(int n, char s, char a, char d) {
		if (n == 1) {
			System.out.printf("Moving disk from %c to %c\n", s, d);
			moveElement(s, d);
			displayArray();
            displayASCII();
			return;
		}
		solve_recursion(n - 1, s, d, a);
		System.out.printf("Moving disk from %c to %c\n", s, d);
		moveElement(s, d);
		displayArray();
        displayASCII();
		solve_recursion(n - 1, a, s, d);
	}

	public void displayArray() {
		for (int i = 0; i < numberOfDisks; i++) {
			System.out.println(Arrays.toString(arrayVisualizer[i]));
		}
	}

	public void displayASCII() {
        int padding = numberOfDisks + 1;
        int characterPointer = 0;
        int totalWidth = (2 * padding) + 1 + (2 * padding) + 1 + (2 * padding) + 1 + (2 * padding);
        System.out.println("THE TOTAL WIDTH IS: " + totalWidth);
        System.out.println("THE PADDING THINGY IS: " + (2 * padding + 1));
        System.out.println(" ".repeat(padding + padding) + "║" + " ".repeat(padding + padding) + "║" + " ".repeat(padding + padding) + "║" + " ".repeat(padding + padding));
        for (int row = 0; row < numberOfDisks; row++) {		
            for (int col = 0; col < 3; col++) {
				int diskSize = arrayVisualizer[row][col];
                // largest disk is (numberOfDisks * 2) + 1 characters wide        
                if (diskSize != 0) { // PRINT THE DISK
					int startAt = (col + 1) * (2 * padding + 1) - diskSize;
					int endAt = startAt + (2 * diskSize);

					while (characterPointer < endAt) {
						characterPointer++;
						if (characterPointer >= startAt) {
                        	System.out.print("█");
						} else {
							System.out.print(" ");
						}
					}
                } else {
                    while (characterPointer <= totalWidth) {
                        characterPointer++;
                        if (characterPointer % (2 * padding + 1) == 0 && characterPointer != 0) {
                            System.out.print("║");
                            break;
                        }
                        System.out.print(" ");
                    }
                }
            }
            characterPointer = 0;
            System.out.println();
        }

        System.out.println("═".repeat(padding + padding) + "╩" + "═".repeat(padding + padding) + "╩" + "═".repeat(padding + padding) + "╩" + "═".repeat(padding + padding));
	}

	// Column indices must be passed
	public void moveElement(char srcRod, char destRod) {
		// Parse the rod, get its column index based on the array
		int diskToMove = 0, srcColumn = 0, destColumn = 0;
		if (srcRod == 'J') srcColumn = 0;
		if (srcRod == 'O') srcColumn = 1;
		if (srcRod == 'Y') srcColumn = 2;
		if (destRod == 'J') destColumn = 0;
		if (destRod == 'O') destColumn = 1;
		if (destRod == 'Y') destColumn = 2;

		// Find the element or disk to move
		for (int row = 0; row < arrayVisualizer.length; row++) {
			if (arrayVisualizer[row][srcColumn] != 0) {
				diskToMove = arrayVisualizer[row][srcColumn]; // Assign diskToMove
				arrayVisualizer[row][srcColumn] = 0; // Assign cell to 0, remove it
				break;
			}
		}

		for (int row = arrayVisualizer.length - 1; row >= 0; row--) { // Loop in reverse
			if (arrayVisualizer[row][destColumn] == 0) {
				arrayVisualizer[row][destColumn] = diskToMove;  // Assign empty cell to copied element
				break;
			}
		}
	}
}

public class lbRecActTwo_Labadan {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of disks: ");
		int numberOfDisks = scan.nextInt();
		Hanoi puzzle = new Hanoi(numberOfDisks, 'J', 'O', 'Y');
		puzzle.solve();

	}
}
