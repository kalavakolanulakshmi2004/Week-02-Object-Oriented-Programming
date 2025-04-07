import java.util.*;
class Patient {
    private String name;
    private Doctor[] consultedDoctors;
    private int doctorCount;
    public Patient(String name, int maxDoctors) {
        this.name = name;
        this.consultedDoctors = new Doctor[maxDoctors];
        this.doctorCount = 0;
    }
    public String getName() {
        return name;
    }
    public void consultDoctor(Doctor doctor) {
        if (doctorCount < consultedDoctors.length) {
            consultedDoctors[doctorCount++] = doctor;
            doctor.consult(this);
        }
    }
    public void showConsultedDoctors() {
        System.out.println("Doctors consulted by " + name + ":");
        for (int i = 0; i < doctorCount; i++) {
            System.out.println("- " + consultedDoctors[i].getName());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of doctors: ");
        int numDoctors = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of patients: ");
        int numPatients = sc.nextInt();
        sc.nextLine();
        Hospital hospital = new Hospital("City Care Hospital", numDoctors, numPatients);
        Doctor[] allDoctors = new Doctor[numDoctors];
        Patient[] allPatients = new Patient[numPatients];
        for (int i = 0; i < numDoctors; i++) {
            System.out.print("Enter doctor name: ");
            String dname = sc.nextLine();
            Doctor doctor = new Doctor(dname, numPatients);
            hospital.addDoctor(doctor);
            allDoctors[i] = doctor;
        }
        for (int i = 0; i < numPatients; i++) {
            System.out.print("Enter patient name: ");
            String pname = sc.nextLine();
            Patient patient = new Patient(pname, numDoctors);
            hospital.addPatient(patient);
            allPatients[i] = patient;
        }
        for (int i = 0; i < numPatients; i++) {
            Patient patient = allPatients[i];
            System.out.println("Consultations for " + patient.getName());
            System.out.print("How many doctors to consult? ");
            int consults = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < consults; j++) {
                System.out.print("Enter doctor name: ");
                String docName = sc.nextLine();
                for (int k = 0; k < numDoctors; k++) {
                    if (allDoctors[k].getName().equalsIgnoreCase(docName)) {
                        patient.consultDoctor(allDoctors[k]);
                        break;
                    }
                }
            }
        }
        System.out.println();
        hospital.showAllDoctors();
        System.out.println();
        hospital.showAllPatients();
        System.out.println();
        for (int i = 0; i < numDoctors; i++) {
            allDoctors[i].showPatients();
        }
        System.out.println();
        for (int i = 0; i < numPatients; i++) {
            allPatients[i].showConsultedDoctors();
        }
    }
}
class Doctor {
    private String name;
    private Patient[] seenPatients;
    private int patientCount;
    public Doctor(String name, int maxPatients) {
        this.name = name;
        this.seenPatients = new Patient[maxPatients];
        this.patientCount = 0;
    }
    public String getName() {
        return name;
    }
    public void consult(Patient patient) {
        if (patientCount < seenPatients.length) {
            seenPatients[patientCount++] = patient;
            System.out.println(name + " consulted " + patient.getName());
        }
    }
    public void showPatients() {
        System.out.println("Patients seen by Dr. " + name + ":");
        for (int i = 0; i < patientCount; i++) {
            System.out.println("- " + seenPatients[i].getName());
        }
    }
}
class Hospital {
    private String hospitalName;
    private Doctor[] doctors;
    private int doctorCount;
    private Patient[] patients;
    private int patientCount;
    public Hospital(String hospitalName, int maxDoctors, int maxPatients) {
        this.hospitalName = hospitalName;
        this.doctors = new Doctor[maxDoctors];
        this.patients = new Patient[maxPatients];
        this.doctorCount = 0;
        this.patientCount = 0;
    }
    public void addDoctor(Doctor doctor) {
        if (doctorCount < doctors.length) {
            doctors[doctorCount++] = doctor;
        }
    }
    public void addPatient(Patient patient) {
        if (patientCount < patients.length) {
            patients[patientCount++] = patient;
        }
    }
    public Doctor[] getDoctors() {
        return Arrays.copyOf(doctors, doctorCount);
    }
    public Patient[] getPatients() {
        return Arrays.copyOf(patients, patientCount);
    }
    public void showAllDoctors() {
        System.out.println("Doctors in " + hospitalName + ":");
        for (int i = 0; i < doctorCount; i++) {
            System.out.println("- " + doctors[i].getName());
        }
    }
    public void showAllPatients() {
        System.out.println("Patients in " + hospitalName + ":");
        for (int i = 0; i < patientCount; i++) {
            System.out.println("- " + patients[i].getName());
        }
    }
}