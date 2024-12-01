class Hanoi {
	int towerDiskStates[][];
	int numberOfDisks, numberOfSteps;
	char source, auxiliary, destination;

	public Hanoi(int n, char source, char auxiliary, char destination) {
		this.source = source; // letter of the source rod
		this.auxiliary = auxiliary; // letter of the auxiliary rod
		this.destination = destination; // letter of the destination rod
		this.numberOfDisks = n;
		this.numberOfSteps = 0;
		this.towerDiskStates = new int[n][3]; // There will only be 3 columns, representing the rods

		/*
		 * Fill the array with values to represent the initial positions of the disks.
		 * Specifically, for numberOfDisks = 3, the `towerDiskStates` array should be structured as follows:
		 *  Src, Aux, Dest
		 *  { 1, 0, 0 },
		 *  { 2, 0, 0 },
		 *  { 3, 0, 0 }
		 *    J  O  Y
		 * Here, '1' represents the smallest disk, '2' the middle disk, and '3' the largest disk.
		 */
		for (int row = 0; row < towerDiskStates.length; row++) {
			this.towerDiskStates[row][0] = row + 1;
		}
	}

	public void reset(int n) {
		this.numberOfDisks = n;
		this.numberOfSteps = 0;
		this.towerDiskStates = null; // Assign null to the array
		this.towerDiskStates = new int[n][3]; // Reassign a new reference to the 2D array with a different size
		for (int row = 0; row < towerDiskStates.length; row++) {
			this.towerDiskStates[row][0] = row + 1;
		}
	}

	public void solve() {
		System.out.println("\n\t  STARTING POSITION\n");
        displayTowersAscii();
		solve_recursion(numberOfDisks, source, auxiliary, destination);
		System.out.printf("\n\t  Minimum # of steps to solve n = %d disks is: %d\n", numberOfDisks, numberOfSteps);
	}

	private void solve_recursion(int n, char s, char a, char d) {
		if (n == 1) {
			System.out.printf("\n\t  STEP #%d: Moving disk from %c to %c\n\n", numberOfSteps + 1, s, d);
			moveElement(s, d);
            displayTowersAscii();
            numberOfSteps++;
			return;
		}
		solve_recursion(n - 1, s, d, a);
		System.out.printf("\n\t  STEP #%d: Moving disk from %c to %c\n\n", numberOfSteps + 1, s, d);
		moveElement(s, d);
        displayTowersAscii();
        numberOfSteps++;
		solve_recursion(n - 1, a, s, d);
	}

	private void displayTowersAscii() {
        int padding = numberOfDisks + 1;
        int cursor = 0; // cursor to indicate the position where to write a certain character in the line
        int totalWidth = (2 * padding) + 1 + (2 * padding) + 1 + (2 * padding) + 1 + (2 * padding); // How many characters are in a line
        printTowersBorder(padding, " ", "║", "║", "║");
        for (int row = 0; row < numberOfDisks; row++) {
			System.out.print("\t");
            for (int col = 0; col < 3; col++) {
				int diskSize = towerDiskStates[row][col];
                if (diskSize != 0) { // PRINT THE DISK
					int startAt = (col + 1) * (2 * padding + 1) - diskSize;
					int endAt = startAt + (2 * diskSize);

					while (cursor < endAt) {
						cursor++;
						if (cursor >= startAt) {
                        	System.out.print("▄");
						} else {
							System.out.print(" ");
						}
					}
                } else { // PRINT SPACES OR ROD
                    while (cursor <= totalWidth) {
                        cursor++;
                        if (cursor % (2 * padding + 1) == 0 && cursor != 0) {
                            System.out.print("║");
                            break;
                        }
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
            cursor = 0; // Reset cursor to zero because we proceed to new line
        }
        printTowersBorder(padding, "═", "╩", "╩", "╩");
        // Print rod letters
        printTowersBorder(padding, " ", String.valueOf(source), String.valueOf(auxiliary), String.valueOf(destination));
	}

	private void printTowersBorder(int padding, String base, String rod1, String rod2, String rod3) {
	    System.out.println("\t" +
			base.repeat(padding * 2) + rod1 +
			base.repeat(padding * 2) + rod2 +
			base.repeat(padding * 2) + rod3 +
			base.repeat(padding * 2)
		);
	}

	// Column indices must be passed, e.g `moveElement('J', 'Y')`
	private void moveElement(char srcRod, char destRod) {
		// // Get the column indices for source and destination rods
		int diskToMove = 0;
		int srcColumn = getColumnIndex(srcRod); // Use helper function to get the index
		int destColumn = getColumnIndex(destRod);

		// Find the element or disk to move
		for (int row = 0; row < towerDiskStates.length; row++) {
			if (towerDiskStates[row][srcColumn] != 0) {
				diskToMove = towerDiskStates[row][srcColumn]; // Assign diskToMove
				towerDiskStates[row][srcColumn] = 0; // Assign current index to 0 indicating that there is no disk
				break;
			}
		}

		for (int row = towerDiskStates.length - 1; row >= 0; row--) { // Loop in reverse
			if (towerDiskStates[row][destColumn] == 0) {
				towerDiskStates[row][destColumn] = diskToMove;  // Assign empty cell to copied element
				break;
			}
		}
	}

	// Helper function to get the column index based on the assigned rod characters
	private int getColumnIndex(char rod) {
		if (rod == source) return 0;
		if (rod == auxiliary) return 1;
		if (rod == destination) return 2;
		return -1; // If rod doesn't exist
	}
}
