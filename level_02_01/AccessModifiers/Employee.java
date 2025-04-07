package AccessModifiers;
import java.util.*;
public class Employee {
    public String employeeID;
    protected String department;
    private double salary;
    public Employee(String employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            System.out.println("Salary updated to: " + salary);
        } else {
            System.out.println("Salary must be positive.");
        }
    }
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}
class Manager extends Employee {
    public Manager(String employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }
    public void displayManagerDetails() {
        System.out.println("Manager Details:");
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}
class EmployeeRecords{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID: ");
        String employeeID = scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Initial Salary: ");
        double salary = scanner.nextDouble();
        Manager manager = new Manager(employeeID, department, salary);
        System.out.println("\nEmployee Details:");
        manager.displayEmployeeDetails();
        System.out.print("\nEnter new salary: ");
        double newSalary = scanner.nextDouble();
        manager.setSalary(newSalary);
        System.out.println("\nUpdated Employee Details:");
        manager.displayEmployeeDetails();
        System.out.println("\nManager Details:");
        manager.displayManagerDetails();
    }
}