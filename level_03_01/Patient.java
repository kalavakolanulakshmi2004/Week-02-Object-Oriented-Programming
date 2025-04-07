package Problems;
import java.util.*;
public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of patients to admit: ");
        int numPatients = scanner.nextInt();
        scanner.nextLine();
        Patient[] patients = new Patient[numPatients];
        for (int i = 0; i < numPatients; i++) {
            System.out.println("\nEnter details for Patient " + (i + 1) + ":");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Ailment: ");
            String ailment = scanner.nextLine();
            System.out.print("Enter Patient ID: ");
            int patientID = scanner.nextInt();
            scanner.nextLine();
            patients[i] = new Patient(name, age, ailment, patientID);
        }
        getTotalPatients();
        for (Patient patient : patients) {
            patient.displayPatientDetails();
        }
    }
}