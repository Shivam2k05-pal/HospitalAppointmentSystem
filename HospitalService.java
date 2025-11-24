package services;

import models.Appointment;
import models.Doctor;
import models.Patient;
import utils.FileHandler;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class HospitalService {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;
    
    private final String DOC_FILE = "doctors.dat";
    private final String PAT_FILE = "patients.dat";
    private final String APP_FILE = "appointments.dat";
    private final int TOTAL_BEDS = 20; // Fixed hospital capacity

    public HospitalService() {
        this.doctors = FileHandler.loadList(DOC_FILE);
        this.patients = FileHandler.loadList(PAT_FILE);
        this.appointments = FileHandler.loadList(APP_FILE);
    }

    // --- DOCTOR OPERATIONS ---
    public void addDoctor(String name, String specialization) {
        String id = "D" + (doctors.size() + 1);
        doctors.add(new Doctor(id, name, specialization));
        FileHandler.saveList(doctors, DOC_FILE);
    }

    public void listDoctors() {
        System.out.println("\n--- DOCTOR LIST ---");
        doctors.forEach(System.out::println);
    }

    // --- PATIENT OPERATIONS (Admissions) ---
    public void admitPatient(String name, int age, String ailment) {
        long occupiedBeds = patients.stream().filter(Patient::isAdmitted).count();
        if (occupiedBeds >= TOTAL_BEDS) {
            System.out.println("ERROR: No beds available!");
            return;
        }
        String id = "P" + (patients.size() + 1);
        patients.add(new Patient(id, name, age, ailment, true));
        FileHandler.saveList(patients, PAT_FILE);
        System.out.println("Patient Admitted to Bed.");
    }

    public void listPatients() {
        System.out.println("\n--- PATIENT RECORDS ---");
        patients.forEach(System.out::println);
    }

    // --- APPOINTMENT OPERATIONS ---
    public void bookAppointment(String docId, String patientName, String date) {
        // Verify doctor exists
        boolean docExists = doctors.stream().anyMatch(d -> d.getId().equals(docId));
        if (!docExists) {
            System.out.println("Error: Doctor ID not found.");
            return;
        }
        String id = UUID.randomUUID().toString().substring(0, 5);
        appointments.add(new Appointment(id, docId, patientName, date));
        FileHandler.saveList(appointments, APP_FILE);
        System.out.println("Appointment Booked!");
    }

    // --- ANALYTICS ---
    public void showAnalytics() {
        System.out.println("\n--- HOSPITAL ANALYTICS ---");
        
        // 1. Bed Occupancy
        long occupied = patients.stream().filter(Patient::isAdmitted).count();
        double rate = (double) occupied / TOTAL_BEDS * 100;
        System.out.println(String.format("Bed Occupancy: %d/%d (%.1f%%)", occupied, TOTAL_BEDS, rate));

        // 2. Doctor Popularity
        System.out.println("Appointments per Doctor:");
        for (Doctor d : doctors) {
            long count = appointments.stream()
                .filter(a -> a.getDoctorId().equals(d.getId()))
                .count();
            System.out.println(" - " + d.getName() + ": " + count);
        }
    }
}