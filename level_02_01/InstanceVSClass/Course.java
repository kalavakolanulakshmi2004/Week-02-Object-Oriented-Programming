package InstanceVSClass;
import java.util.*;
public class Course {
    String courseName;
    int duration;
    double fee;
    static String instituteName = "Default Institute";
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration + " months, Fee: " + fee);
        System.out.println("Institute Name: " + instituteName);
    }
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();
        sc.nextLine();
        Course[] courses = new Course[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter course name: ");
            String name = sc.nextLine();
            System.out.println("Enter course duration (in months):");
            int duration = sc.nextInt();
            System.out.println("Enter course fee:");
            double fee = sc.nextDouble();
            sc.nextLine();
            courses[i] = new Course(name, duration, fee);
        }
        System.out.println("\nEnter new institute name to update for all courses:");
        String newInstituteName = sc.nextLine();
        Course.updateInstituteName(newInstituteName);
        System.out.println("\nCourse Details:");
        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }
}
