package models;

import java.io.Serializable;

public class Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private int age;
    private String ailment;
    private boolean isAdmitted; // Consumes a bed if true

    public Patient(String id, String name, int age, String ailment, boolean isAdmitted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.isAdmitted = isAdmitted;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public boolean isAdmitted() { return isAdmitted; }
    
    public void discharge() { this.isAdmitted = false; }

    @Override
    public String toString() {
        return String.format("ID: %s | %s | Age: %d | Ailment: %s | Bed: %s", 
            id, name, age, ailment, isAdmitted ? "Occupied" : "None");
    }
}