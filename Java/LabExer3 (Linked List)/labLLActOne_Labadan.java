import java.util.Scanner;

public class labLLActOne_Labadan {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        Employee instance = new Employee();
        String continueOption;
        int option;

        do {
            displayMenu();

            System.out.print("\n\t- Enter option no.: ");
            option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                System.out.print("\t- Enter the name of the employee: ");
                String name = scan.nextLine();
                System.out.print("\t- Enter the id of the employee: ");
                String id = scan.nextLine();
                instance.insertEmployee(name, id);
            } else if (option == 2) {
                System.out.print("\t- Enter the id of the employee: ");
                String id = scan.nextLine();
                instance.deleteEmployee(id);
            } else if (option == 3) {
                instance.displayAllEmployee();
            } else if (option == 4) {
                System.out.print("\t- Enter the id of the employee: ");
                String id = scan.nextLine();
                instance.searchEmployee(id);
            } else if (option == 5) {
                System.out.println("\n\t-- EXITING PROGRAM! --");
                break;
            } else {
                System.out.println("\n\t-- INVALID INPUT! --");
            }

            System.out.print("\n\t- Do you wish to continue? [YES/NO]: ");
            continueOption = scan.nextLine();

        } while (continueOption.equalsIgnoreCase("yes"));
    }

    public static void displayMenu() {
        System.out.println("\n\t+==========================================+");
        System.out.println("\t|       EMPLOYEE LINKED LIST PROGRAM       |");
        System.out.println("\t+==========================================+");
        System.out.println("\t|                                          |");
        System.out.println("\t|  [1] - INSERT an employee in the list    |");
        System.out.println("\t|  [2] - DELETE an employee in the list    |");
        System.out.println("\t|  [3] - DISPLAY all employees info        |");
        System.out.println("\t|  [4] - SEARCH an employee using id       |");
        System.out.println("\t|  [5] - Exit                              |");
        System.out.println("\t|                                          |");
        System.out.println("\t+==========================================+");
    }
}