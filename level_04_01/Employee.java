import java.util.*;
class Employee {
    private String name;
    private int id;
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void displayEmployee() {
        System.out.println("  Employee ID: " + id + ", Name: " + name);
    }
}
class Department {
    private String deptName;
    private List<Employee> employees;
    public Department(String deptName) {
        this.deptName = deptName;
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}
class Company {
    private String companyName;
    private List<Department> departments;
    public Company(String companyName) {
        this.companyName = companyName;
        departments = new ArrayList<>();
    }
    public void addDepartment(Department dept) {
        departments.add(dept);
    }
    public void displayCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }
    public void deleteCompany() {
        departments.clear();
        System.out.println("Company " + companyName + " and all its departments and employees are deleted.");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Company company = new Company("TechCorp");
        System.out.print("Enter number of departments: ");
        int deptCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < deptCount; i++) {
            System.out.print("Enter name of department " + (i + 1) + ": ");
            String deptName = sc.nextLine();
            Department dept = new Department(deptName);
            System.out.print("Enter number of employees in " + deptName + ": ");
            int empCount = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < empCount; j++) {
                System.out.print("Enter name of employee " + (j + 1) + ": ");
                String empName = sc.nextLine();
                System.out.print("Enter ID of employee " + (j + 1) + ": ");
                int empId = sc.nextInt();
                sc.nextLine();
                Employee emp = new Employee(empName, empId);
                dept.addEmployee(emp);
            }
            company.addDepartment(dept);
        }
        company.displayCompanyStructure();
        System.out.print("Do you want to delete the company? (yes/no): ");
        String delete = sc.nextLine();
        if (delete.equalsIgnoreCase("yes")) {
            company.deleteCompany();
        }
    }
}