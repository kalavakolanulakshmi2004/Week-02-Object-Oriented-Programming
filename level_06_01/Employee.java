import java.util.Scanner;
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public void assignDepartment(String dept) {
        this.department = dept;
    }
    public String getDepartmentDetails() {
        return department;
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("ID: " + getEmployeeId() + ", Name: " + getName()
                + ", Base Salary: " + getBaseSalary()
                + ", Department: " + getDepartmentDetails()
                + ", Total Salary: " + calculateSalary());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[2];
        FullTimeEmployee e1 = new FullTimeEmployee();
        System.out.println("Enter details for Full-Time Employee:");
        System.out.print("ID: ");
        e1.setEmployeeId(sc.nextInt());
        sc.nextLine();
        System.out.print("Name: ");
        e1.setName(sc.nextLine());
        System.out.print("Base Salary: ");
        e1.setBaseSalary(sc.nextDouble());
        sc.nextLine();
        System.out.print("Department: ");
        e1.assignDepartment(sc.nextLine());
        employees[0] = e1;
        PartTimeEmployee e2 = new PartTimeEmployee();
        System.out.println("Enter details for Part-Time Employee:");
        System.out.print("ID: ");
        e2.setEmployeeId(sc.nextInt());
        sc.nextLine();
        System.out.print("Name: ");
        e2.setName(sc.nextLine());
        System.out.print("Hours Worked: ");
        e2.setHoursWorked(sc.nextInt());
        System.out.print("Hourly Rate: ");
        e2.setHourlyRate(sc.nextDouble());
        sc.nextLine();
        System.out.print("Department: ");
        e2.assignDepartment(sc.nextLine());
        employees[1] = e2;
        System.out.println("\nEmployee Details:");
        for (Employee e : employees) {
            e.displayDetails();
        }
    }
}
class FullTimeEmployee extends Employee {
    public double calculateSalary() {
        return getBaseSalary();
    }
}
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public int getHoursWorked() {
        return hoursWorked;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}