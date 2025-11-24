import services.HospitalService;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HospitalService hospital = new HospitalService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== HOSPITAL MANAGEMENT SYSTEM ===");
            System.out.println("1. Admit New Patient (Bed Allocation)");
            System.out.println("2. Add New Doctor");
            System.out.println("3. Book Appointment");
            System.out.println("4. View All Records (Doctors & Patients)");
            System.out.println("5. View Analytics (Occupancy & Load)");
            System.out.println("6. Exit");
            System.out.print("Select Option: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    System.out.println("\n--- NEW ADMISSION ---");
                    System.out.print("Patient Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = getIntInput();
                    System.out.print("Ailment/Condition: ");
                    String ail = scanner.nextLine();
                    hospital.admitPatient(pName, age, ail);
                    break;
                case 2:
                    System.out.println("\n--- REGISTER DOCTOR ---");
                    System.out.print("Doctor Name: ");
                    String dName = scanner.nextLine();
                    System.out.print("Specialization (e.g., Cardio, Neuro): ");
                    String spec = scanner.nextLine();
                    hospital.addDoctor(dName, spec);
                    break;
                case 3:
                    System.out.println("\n--- BOOK APPOINTMENT ---");
                    hospital.listDoctors();
                    System.out.print("Enter Doctor ID (e.g., D1): ");
                    String docId = scanner.nextLine();
                    System.out.print("Patient Name: ");
                    String patName = scanner.nextLine();
                    System.out.print("Date (DD/MM/YYYY): ");
                    String date = scanner.nextLine();
                    hospital.bookAppointment(docId, patName, date);
                    break;
                case 4:
                    hospital.listPatients();
                    hospital.listDoctors();
                    break;
                case 5:
                    hospital.showAnalytics();
                    break;
                case 6:
                    System.out.println("Saving data and exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}