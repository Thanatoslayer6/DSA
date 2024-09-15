import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class lbArrayActTwo_Labadan {

    // Create a global ArrayList to store students
    public static ArrayList<Student> myStudents = new ArrayList<>();

    public static Scanner scan = new Scanner(System.in);

    public static void main(String args[]) {

        // Add 5 students in the list, instantiate the Student class
        myStudents.add(new Student("Rico", "2023-106521", 90.5, 95.0, 98.0)); 
        myStudents.add(new Student("Brent", "2020-102345", 99.5, 90.5, 98.0));
        myStudents.add(new Student("Charlie", "2019-102452", 92.0, 91.5, 89.0));
        myStudents.add(new Student("Diana", "2018-200311", 85.0, 88.0, 91.0));
        myStudents.add(new Student("Edward", "2021-123458", 79.0, 84.0, 77.5));

        int option;
        do {
            System.out.println("\n\t+=======================================+");
            System.out.println("\t|      STUDENT INFORMATION PROGRAM      |");
            System.out.println("\t+=======================================+");
            System.out.println("\t|                                       |");
            System.out.println("\t|  [1] - Add Student in the list        |");
            System.out.println("\t|  [2] - Remove Student in the list     |");
            System.out.println("\t|  [3] - Show individual student info   |");
            System.out.println("\t|  [4] - List all students info         |");
            System.out.println("\t|  [5] - Exit                           |");
            System.out.println("\t|                                       |");
            System.out.println("\t+=======================================+");
            System.out.print("\n\t- Enter option no.: ");
            option = scan.nextInt();

            if (option == 1) {
                addStudent();
            } else if (option == 2) {
                removeStudent();
            } else if (option == 3) {
                showIndividualStudentInfo();
            } else if (option == 4) {
                Student.displayAllStudentInfo(myStudents);
            } else if (option == 5) {
                System.out.println("\tExiting program...");
                break;
            }
        } while (option >= 1 && option <= 6);
    }

    public static void addStudent() {
        scan.nextLine();
        System.out.print("\tEnter the name of the student: ");
        String name = scan.nextLine();
        System.out.print("\tEnter the student number: ");
        String number = scan.nextLine();
        System.out.print("\tEnter the student's grade in Calculus: ");
        double calculusGrade = scan.nextDouble();
        System.out.print("\tEnter the student's grade in Programming: ");
        double programmingGrade = scan.nextDouble();
        System.out.print("\tEnter the student's grade in Logic: ");
        double logicGrade = scan.nextDouble();
        myStudents.add(new Student(name, number, calculusGrade, programmingGrade, logicGrade));
    }

    public static void removeStudent() {
        System.out.print("\tEnter the student number for removal: ");
        String studentNumber = scan.nextLine();
        // We use the Iterator class to safely remove the student from the list
        Iterator<Student> iterator = myStudents.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next(); 
            if (student.number.equalsIgnoreCase(studentNumber)) {
                iterator.remove();
                System.out.printf("\t%s - %s, has been removed from the list.", student.name, student.number);
                return; // Exit the method once the student is found and removed
            }
        }

        // If no student with the given student number was found
        System.out.println("\tNo student with the no. " + studentNumber + " found.");
    }

    public static void showIndividualStudentInfo() {
        System.out.print("\tEnter the student number: ");
        String studentNumber = scan.nextLine();

        for (Student student : myStudents) {
            if (student.number.equalsIgnoreCase(studentNumber)) {
                student.displayInfo();
                return;
            }
        }
        // We use the Iterator class to safely remove the student from the list
        // Iterator<Student> iterator = myStudents.iterator();
        // while (iterator.hasNext()) {
        //     Student student = iterator.next(); 
        //     if (student.number.equalsIgnoreCase(studentNumber)) {
        //         // iterator.remove();
        //         iterator.displayInfo();
        //         // System.out.printf("%s - %s, has been removed from the list.", student.name, student.number);
        //         return; // Exit the method once the person is found and removed
        //     }
        // }

        // If no student with the given student number was found
        System.out.println("\tNo student with the no. " + studentNumber + " found.");
    }

}
