import java.util.ArrayList;

class Student {
    String name, number;
    double calculusGrade, programmingGrade, logicGrade, averageGrade;

    public Student(String name, String number, double calculusGrade, double programmingGrade, double logicGrade) {
        this.name = name;
        this.number = number;
        this.calculusGrade = calculusGrade;
        this.programmingGrade = programmingGrade;
        this.logicGrade = logicGrade;
        this.averageGrade = calculateAverageGrade();
    }

    public double calculateAverageGrade() {
        return (calculusGrade + programmingGrade + logicGrade) / 3;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Number: " + number);
        System.out.println("Calculus Grade: " + calculusGrade);
        System.out.println("Programming Grade: " + programmingGrade);
        System.out.println("Logic Grade: " + logicGrade);
        System.out.println("Average Grade: " + averageGrade);
        System.out.println();
    }

    public static void displayAllStudentInfo(ArrayList<Student> students) {
        System.out.println("+==============================================================================+");
        System.out.println("|                         COMPLETE STUDENT RECORDS                             |");
        System.out.println("+============+================+============+===============+=========+=========+");
        System.out.println("|    Name    |   Student No.  |  Calculus  |  Programming  |  Logic  | Average |");
        System.out.println("+============+================+============+===============+=========+=========+");
        // Loop over the students array 
        for (Student student : students) {
            System.out.printf("|   %-9s", student.name); // Name
            System.out.printf("|   %-13s", student.number); // Student no.
            System.out.printf("|   %-9.3f", student.calculusGrade); // Calculus Grade
            System.out.printf("|   %-12.3f", student.programmingGrade); // Programming Grade
            System.out.printf("|  %-7.3f", student.logicGrade); // Logic Grade
            System.out.printf("|  %-7.3f|\n", student.averageGrade); // Average Grade
            System.out.println("+============+================+============+===============+=========+=========+");
        }
    }
    
}
