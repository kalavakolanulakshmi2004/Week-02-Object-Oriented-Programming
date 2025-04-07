package level2;
import java.util.Scanner;
public class Student {
    private String name;
    private int rollNumber;
    private double marks;
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    public String calculateGrade() {
        if (marks >= 80) return "A";
        else if (marks >= 70 &&marks<=79) return "B";
        else if (marks >= 60 &&marks<=69)  return "C";
        else if (marks >= 50 &&marks<=59)  return "D";
        else if (marks >= 40 &&marks<=49)  return "E";
        else return "R";
    }
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = sc.nextInt();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        Student student = new Student(name, rollNumber, marks);
        student.displayDetails();
    }
}
