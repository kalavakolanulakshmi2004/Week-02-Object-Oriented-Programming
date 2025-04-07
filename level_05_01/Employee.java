import java.util.*;
class Employee {
    protected String name;
    protected int id;
    protected double salary;
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Manager details: ");
        System.out.print("Name: ");
        String mName = scanner.next();
        System.out.print("ID: ");
        int mId = scanner.nextInt();
        System.out.print("Salary: ");
        double mSalary = scanner.nextDouble();
        System.out.print("Team Size: ");
        int teamSize = scanner.nextInt();
        Employee manager = new Manager(mName, mId, mSalary, teamSize);
        System.out.println("\nEnter Developer details: ");
        System.out.print("Name: ");
        String dName = scanner.next();
        System.out.print("ID: ");
        int dId = scanner.nextInt();
        System.out.print("Salary: ");
        double dSalary = scanner.nextDouble();
        System.out.print("Programming Language: ");
        String programmingLanguage = scanner.next();
        Employee developer = new Developer(dName, dId, dSalary, programmingLanguage);
        System.out.println("\nEnter Intern details: ");
        System.out.print("Name: ");
        String iName = scanner.next();
        System.out.print("ID: ");
        int iId = scanner.nextInt();
        System.out.print("Salary: ");
        double iSalary = scanner.nextDouble();
        System.out.print("Internship Duration (months): ");
        int duration = scanner.nextInt();
        Employee intern = new Intern(iName, iId, iSalary, duration);
        System.out.println("\nEmployee Details:");
        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}
class Manager extends Employee {
    private int teamSize;
    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}
class Developer extends Employee {
    private String programmingLanguage;
    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}
class Intern extends Employee {
    private int duration;
    public Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + duration + " months");
    }
}