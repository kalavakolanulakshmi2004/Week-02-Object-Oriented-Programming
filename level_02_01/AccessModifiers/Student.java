package AccessModifiers;
import java.util.Scanner;
public class Student {
    public String rollNumber;
    protected String name;
    private double CGPA;
    public Student(String rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }
    public double getCGPA() {
        return CGPA;
    }
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}
class PostgraduateStudent extends Student {
    public PostgraduateStudent(String rollNumber, String name, double CGPA) {
        super(rollNumber, name, CGPA);
    }
    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        displayStudentDetails();
    }
}
class UniversityManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter CGPA: ");
        double CGPA = scanner.nextDouble();
        PostgraduateStudent pgStudent = new PostgraduateStudent(rollNumber, name, CGPA);
        pgStudent.displayPostgraduateDetails();
        System.out.print("\nEnter updated CGPA: ");
        double updatedCGPA = scanner.nextDouble();
        pgStudent.setCGPA(updatedCGPA);
        System.out.println("\nUpdated Details:");
        pgStudent.displayPostgraduateDetails();
    }
}