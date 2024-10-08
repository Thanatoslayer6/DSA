import java.util.LinkedList;

public class Employee {
    public String name;
    public String id;
    public static LinkedList<Employee> list = new LinkedList<Employee>();

    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Overload the constructor in order to access the `list` property in main()
    public Employee() {
        return; 
    }

    public void insertEmployee(String name, String id) {
        System.out.println("\n\t* Inserted new employee from the list:");
        System.out.println("\t  - Name: " + name);
        System.out.println("\t  - Employee Id: " + id);
        this.list.add(new Employee(name, id));
    }

    public void deleteEmployee(String id) {
        if (this.list.isEmpty()) {
            System.out.println("\n\t-- LIST IS EMPTY! --");
            return;
        }
        // Perform a linear search to find the employee
        for (Employee employee : this.list) {
            if ((employee.id).equals(id)) {
                this.list.remove(employee);
                System.out.println("\n\t* Deleted employee from the list:");
                System.out.println("\t  - Name: " + employee.name);
                System.out.println("\t  - Employee Id: " + employee.id);
                return;
            }
        }
        System.out.println("\n\t-- EMPLOYEE NOT FOUND! --");
    }

    public void displayAllEmployee() {
        if (this.list.isEmpty()) {
            System.out.println("\n\t-- LIST IS EMPTY! --");
            return;
        }
        for (int i = 0; i < this.list.size(); i++) { 
            Employee employee = this.list.get(i);
            System.out.println("\n\t* Employee at index: " + i);
            System.out.println("\t  - Name: " + employee.name);
            System.out.println("\t  - Employee Id: " + employee.id);
        }
    }

    public void searchEmployee(String id) {
        if (this.list.isEmpty()) {
            System.out.println("\n\t-- LIST IS EMPTY! --");
            return;
        }
        for (Employee employee : this.list) {
            if ((employee.id).equals(id)) {
                System.out.println("\n\t* Searched employee:");
                System.out.println("\t  - Name: " + employee.name);
                System.out.println("\t  - Employee Id: " + employee.id);
                return;
            }
        }
        System.out.println("\n\t-- EMPLOYEE NOT FOUND! --");
    }
}
