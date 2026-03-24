package com.hospital.management;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagement{

    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addPatient(scanner);
                    break;

                case 2:
                    addDoctor(scanner);
                    break;

                case 3:
                    scheduleAppointment(scanner);
                    break;

                case 4:
                    viewPatients();
                    break;

                case 5:
                    viewDoctors();
                    break;

                case 6:
                    viewAppointments();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // ✅ Add Patient
    private static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Gender: ");
        String gender = scanner.next();

        Patient p = new Patient(name, gender, age);
        patients.add(p);

        System.out.println("Patient added successfully!");
    }

    // ✅ Add Doctor
    private static void addDoctor(Scanner scanner) {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.next();

        System.out.print("Enter Specialization: ");
        String spec = scanner.next();

        Doctor d = new Doctor(name, spec);
        doctors.add(d);

        System.out.println("Doctor added successfully!");
    }

    // ✅ Schedule Appointment
    private static void scheduleAppointment(Scanner scanner) {

        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Add patients and doctors first!");
            return;
        }

        System.out.println("\nSelect Patient:");
        for (int i = 0; i < patients.size(); i++) {
            System.out.println(i + ". " + patients.get(i));
        }
        int pIndex = scanner.nextInt();

        System.out.println("Select Doctor:");
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println(i + ". " + doctors.get(i));
        }
        int dIndex = scanner.nextInt();

        System.out.print("Enter Date: ");
        String date = scanner.next();

        Appointment a = new Appointment(
                patients.get(pIndex),
                doctors.get(dIndex),
                date
        );

        appointments.add(a);

        System.out.println("Appointment scheduled!");
    }

    // ✅ View Patients
    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    // ✅ View Doctors
    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    // ✅ View Appointments
    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment a : appointments) {
            System.out.println(a);
        }
    }
}