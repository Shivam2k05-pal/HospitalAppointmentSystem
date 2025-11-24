# Hospital Bed & Appointment System

### Overview

The Hospital Bed & Appointment System is a Java-based console application designed to digitize the management of hospital resources. It solves the problem of manual tracking by providing a centralized system for patient admissions (bed management), doctor registries, and outpatient appointment scheduling.

### Features

Patient Admission (Bed Management):

Admits patients and assigns beds automatically.

Enforces a strict limit (20 beds) to simulate capacity constraints.

Tracks patient details including age and ailment.

### Doctor Management:

Maintains a digital registry of doctors and their specializations.

Generates unique IDs for medical staff.

### Appointment System:

Links patients to specific doctors.

Validates doctor existence before booking.

### Analytics Dashboard:

Bed Occupancy: Real-time percentage of beds in use.

Doctor Load: Tracks which doctors have the most appointments.

### Data Persistence:

Uses File I/O (Serialization) to save patients.dat, doctors.dat, and appointments.dat locally.

Data is not lost when the application closes.

Technologies Used

Language: Java (JDK 17+)

Concepts: Object-Oriented Programming (OOP), Collection Framework, File I/O, Stream API.

Tools: VS Code, Git.

Steps to Install & Run

Clone the Repository:

git clone [https://github.com/YourUsername/HospitalManagementSystem.git](https://github.com/YourUsername/HospitalManagementSystem.git)


Compile the Code:
Open the folder and run the run_project.bat (Windows) or run_project.sh (Mac/Linux) script.

Alternatively, compile manually:

javac -d bin src/Main.java src/models/*.java src/services/*.java src/utils/*.java


Run the Application:

java -cp bin Main


### Instructions for Testing

**Admit a Patient:** Select Option 1. Enter details. Verify the "Bed Occupancy" increases in Analytics (Option 5).

**Book Appointment:** Add a Doctor (Option 2), then Book Appointment (Option 3). Use the Doctor ID provided in the list.


**Check Persistence:** Close the app (Option 6), reopen it, and select "View All Records" (Option 4). Your data should still be there.
