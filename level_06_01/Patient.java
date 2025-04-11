import java.util.Scanner;
interface MedicalRecord {
    void addRecord(String record);
    String viewRecord();
}
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis;
    private String medicalHistory;
    private String record;
    public Patient(int patientId, String name, int age, String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
    }
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Medical History: " + medicalHistory);
        System.out.println("Record: " + viewRecord());
    }
    public void addRecord(String record) {
        this.record = record;
    }
    public String viewRecord() {
        return record;
    }
    public abstract double calculateBill();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter InPatient details:");
        System.out.print("ID: ");
        int inId = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String inName = sc.nextLine();
        System.out.print("Age: ");
        int inAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Diagnosis: ");
        String inDiag = sc.nextLine();
        System.out.print("Medical History: ");
        String inHist = sc.nextLine();
        System.out.print("Days Admitted: ");
        int days = sc.nextInt();
        System.out.print("Cost per Day: ");
        double cost = sc.nextDouble();
        sc.nextLine();
        System.out.print("Medical Record: ");
        String inRecord = sc.nextLine();
        Patient inPatient = new InPatient(inId, inName, inAge, inDiag, inHist, days, cost);
        inPatient.addRecord(inRecord);
        System.out.println("\nEnter OutPatient details:");
        System.out.print("ID: ");
        int outId = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String outName = sc.nextLine();
        System.out.print("Age: ");
        int outAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Diagnosis: ");
        String outDiag = sc.nextLine();
        System.out.print("Medical History: ");
        String outHist = sc.nextLine();
        System.out.print("Consultation Fee: ");
        double fee = sc.nextDouble();
        sc.nextLine();
        System.out.print("Medical Record: ");
        String outRecord = sc.nextLine();
        Patient outPatient = new OutPatient(outId, outName, outAge, outDiag, outHist, fee);
        outPatient.addRecord(outRecord);
        System.out.println("\nBilling and Patient Details\n");
        System.out.println("InPatient:");
        inPatient.getPatientDetails();
        System.out.println("Bill Amount: ₹" + inPatient.calculateBill());
        System.out.println("\nOutPatient:");
        outPatient.getPatientDetails();
        System.out.println("Bill Amount: ₹" + outPatient.calculateBill());
    }
}
class InPatient extends Patient {
    private int daysAdmitted;
    private double costPerDay;
    public InPatient(int id, String name, int age, String diagnosis, String history, int daysAdmitted, double costPerDay) {
        super(id, name, age, diagnosis, history);
        this.daysAdmitted = daysAdmitted;
        this.costPerDay = costPerDay;
    }
    public double calculateBill() {
        return daysAdmitted * costPerDay;
    }
}
class OutPatient extends Patient {
    private double consultationFee;
    public OutPatient(int id, String name, int age, String diagnosis, String history, double consultationFee) {
        super(id, name, age, diagnosis, history);
        this.consultationFee = consultationFee;
    }
    public double calculateBill() {
        return consultationFee;
    }
}