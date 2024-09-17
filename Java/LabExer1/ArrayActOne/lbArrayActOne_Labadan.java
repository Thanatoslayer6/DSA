public class lbArrayActOne_Labadan {
    public static void main(String args[]) {
        String[][][] arr = {
            // Index 0
            {
              // Col0  Col1  Col2  Col3
                {"1A", "2B", "3C", "4D"}, // Row 0
                {"5E", "6F", "7G", "8H"} // Row 1
            },
            // Index 1
            {
              // Col0   Col1   Col2
                {"Z26", "Y25", "X24"}, // Row 0
                {"W23", "V22", "U21"}, // Row 1
            },
        };

        // Initialize iterators
        int index = 0, row = 0, col = 0;

        System.out.println("\n\t\t~ Displaying a 3D array ~");

        for (index = 0; index < arr.length; index++) {

            int numberOfColumns = arr[index][0].length;

			printTableTopBorder(numberOfColumns);
            printColumnHeaders(index, numberOfColumns);
            printTableTopBorder(numberOfColumns);

            for (row = 0; row < arr[index].length; row++) {
                System.out.printf("\t|%8s", "  Row " + row + "  |");
                for (col = 0; col < arr[index][row].length; col++) {
                    System.out.printf("%8s", arr[index][row][col] + "  |");
                }
                printTableTopBorder(numberOfColumns);
            }
            System.out.println();
        }

    }

    // Display methods for a tabular output design
    public static void printColumnHeaders(int index, int numOfCols) {
        System.out.printf("\t|%8s ", "Index " + index);
        for (int i = 0; i < numOfCols; i++) {
            System.out.printf("%8s", "| Col " + i + " ");
        }
        System.out.print("|");
    }

    public static void printTableTopBorder(int numOfCols) {
        System.out.print("\n\t+---------");
        for (int i = 0; i < numOfCols; i++) {
            System.out.print("+-------");
        }
        System.out.println("+");
    }
}
