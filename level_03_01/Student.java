package Problems;
import java.util.*;
public class Student {
    private static String universityName = "Global University";
    private static int totalStudents = 0;
    private final int rollNumber;
    private String name;
    private char grade;
    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Grade: " + grade);
        }
    }
    public void updateGrade(char newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Updated grade for " + name + ": " + grade);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students to enroll: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        Student[] students = new Student[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Roll Number: ");
            int rollNumber = scanner.nextInt();
            System.out.print("Enter Grade (A/B/C/D/E/R): ");
            char grade = scanner.next().charAt(0);
            scanner.nextLine();
            students[i] = new Student(name, rollNumber, grade);
        }
        displayTotalStudents();
        for (Student student : students) {
            student.displayStudentDetails();
        }
        System.out.print("\nEnter roll number to update grade: ");
        int rollToUpdate = scanner.nextInt();
        System.out.print("Enter new grade: ");
        char newGrade = scanner.next().charAt(0);
        for (Student student : students) {
            if (student.rollNumber == rollToUpdate) {
                student.updateGrade(newGrade);
                break;
            }
        }
    }
}
