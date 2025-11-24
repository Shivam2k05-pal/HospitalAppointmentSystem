package models;

import java.io.Serializable;

public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    private String appointmentId;
    private String doctorId;
    private String patientName;
    private String date;

    public Appointment(String appointmentId, String doctorId, String patientName, String date) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientName = patientName;
        this.date = date;
    }

    public String getDoctorId() { return doctorId; }

    @Override
    public String toString() {
        return String.format("Appt [%s]: Patient %s with Doc ID %s on %s", 
            appointmentId, patientName, doctorId, date);
    }
}