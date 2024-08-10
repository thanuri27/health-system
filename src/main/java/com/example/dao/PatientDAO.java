package com.example.dao;

// Import statement for the required class
import com.example.model.Patient;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;

// PatientDAO extends PersonDAO
public class PatientDAO extends PersonDAO {

    // Declare a static list to hold all Patient objects
    private static final List<Patient> Patients = new ArrayList<>();

    // Static initializer block to add some sample Patient objects
    static {
        Patients.add(new Patient(1, "Patient01", "male", "lane01", "yes", "good", 25));
        Patients.add(new Patient(2, "Patient02", "male", "lane02", "no", "good", 43));
        // Add more students as needed
    }

    // Method to get all Patients
    public static List<Patient> getAllPatients() {
        return Patients;
    }

    // Create method to add a new Patient
    public void add_Patient(Patient patient) {
        int newpatientId = getNextPatientId(); // Get the next available ID
        patient.setID(newpatientId); // Set the ID for the new Patient
        addPerson(patient); // Add the Patient to the base PersonDAO
        Patients.add(patient); // Add the Patient to the Patients list
    }

    // Method to retrieve a Patient by ID
    public Patient getPatientById(int id) {
        for (Patient patient : Patients) {
            if (patient.getID() == id) {
                return patient;
            }
        }
        return null; // If no Patient found, return null
    }

    // Delete method to remove a Patient by ID
    public void delete_Patient(int id) throws NotFoundException {
        Patients.removeIf(patientt -> patientt.getID() == id); // Remove the Patient from the list
    }

    // Update method to update an existing Patient
    public void update_Patient(Patient updatedPatient) {
        for (int i = 0; i < Patients.size(); i++) {
            Patient patient = Patients.get(i);
            if (patient.getID() == updatedPatient.getID()) {
                Patients.set(i, updatedPatient); // Update the Patient in the list
                System.out.println("patient updated: " + updatedPatient);
                return;
            }
        }
    }

    // Helper method to get the next available ID for a new Patient
    public int getNextPatientId() {
        int maxpatientId = Integer.MIN_VALUE;
        for (Patient patient : Patients) {
            int userId = patient.getID();
            if (userId > maxpatientId) {
                maxpatientId = userId;
            }
        }
        return maxpatientId + 1; // Return the next available ID
    }
}