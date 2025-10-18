package hospital_management_project;

import hospital_management_system.Appointment;
import hospital_management_system.Doctor;
import hospital_management_system.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagement {
    private static ArrayList<Patient> patients= new ArrayList<>();
    private static ArrayList<Doctor> doctors= new ArrayList<>();
    private static ArrayList<Appointment> appointments= new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {


            System.out.println("Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctor");
            System.out.println("6. View Appointment");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer after reading number
            switch (choice) {
                case 1:
                    addPatient(sc);
                    break;
                case 2:
                    addDoctor(sc);
                    break;
                case 3:
                    scheduleAppointment(sc);
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctor();
                    break;
                case 6:
                    viewAppointment();
                    break;
                case 0:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Invalid choice ! Please try again");
            }
        }while (choice != 0);

    }

    private static void addPatient(Scanner sc){
        System.out.println("Enter the patient name: ");
        String name = sc.next();
        System.out.println("Enter patient age: ");
        int age = sc.nextInt();
        System.out.println("Enter patient gender: ");
        String gender = sc.next();

        Patient patient = new Patient(name, gender, age);
        patients.add(patient);
        System.out.println("Patient successfully added");


    }

    private static void addDoctor(Scanner sc){
        System.out.println("Enter the doctor name: ");
        String name = sc.nextLine();
        System.out.println("Enter doctor speciality: ");
        String speciality = sc.nextLine();

        Doctor doctor = new Doctor(name,speciality);
        doctors.add(doctor);
        System.out.println("Doctor added successfully");

    }
    private static void scheduleAppointment(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.next();

        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor, date);
            appointments.add(appointment);
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Invalid Patient ID or Doctor ID.");
        }
    }

    private static void viewPatients() {
        System.out.println("List of Patients:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
    private static void viewDoctor() {
        System.out.println("List of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println(doctor);
        }
    }
    private static void viewAppointment() {
        System.out.println("List of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

}



