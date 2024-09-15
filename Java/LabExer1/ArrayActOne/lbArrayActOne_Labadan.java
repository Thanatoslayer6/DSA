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

        System.out.println("\n ~ Displaying a 3D array ~ \n");

        for (index = 0; index < arr.length; index++) {

            System.out.printf("%-8s", "Index " + index);

            // Note: no. of columns is `arr[index][0].length`
            int numberOfColumns = arr[index][0].length;
            printColumnHeaders(numberOfColumns); 
            printGridSides(numberOfColumns); 

            for (row = 0; row < arr[index].length; row++) {
                System.out.printf("%-8s", " Row " + row);
                for (col = 0; col < arr[index][row].length; col++) {
                    System.out.printf("%-8s", "|  " + arr[index][row][col] + "  ");
                }
                printGridSides(numberOfColumns);
            }
            System.out.println();
        }

    }

    // Output methods for a better output design
    public static void printColumnHeaders(int numOfCols) {
        for (int i = 0; i < numOfCols; i++) {
            System.out.printf("%-8s", "| Col " + i + " ");
        }
    }

    public static void printGridSides(int numOfCols) {
        System.out.print("\n--------");
        for (int i = 0; i < numOfCols; i++) {
            System.out.print("+-------");
        }
        System.out.println();
    }
}
