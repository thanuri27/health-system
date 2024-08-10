/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// This is a standard Java package declaration
package com.example.dao;

// Import statements for the required classes
import com.example.model.Doctor;
import com.example.model.Patient;
import com.example.model.Prescription;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;

// This class defines a Data Access Object (DAO) for managing Prescriptions
public class PrescriptionDAO {

    // Declare a static list to hold all Prescription objects
    private static final List<Prescription> Prescription_List = new ArrayList<>();

    // Static initializer block to add some sample Prescription objects
    static {
        // Get all Patients and Doctors from their respective DAOs
        List<Patient> Patients_List = PatientDAO.getAllPatients();
        List<Doctor> Doctors_List = DoctorDAO.getAllDoctors();

        // Add two sample Prescription objects to the list
        Prescription_List.add(new Prescription(Patients_List.get(1), Doctors_List.get(1), "", 1, "Instructin01", 10));
        Prescription_List.add(new Prescription(Patients_List.get(0), Doctors_List.get(0), "", 2, "Instructin02", 5));
    }

    // Method to retrieve all Prescriptions
    public List<Prescription> getAllPrescriptions() {
        return Prescription_List;
    }

    // Method to add a new Prescription
    public void add_Prescription(Prescription prescription) {
        Prescription_List.add(prescription);
    }

    // Method to retrieve a Prescription by Patient ID
    public Prescription getPrescription(int id) throws NotFoundException {
        for (Prescription prescription : Prescription_List) {
            if (prescription.getPatient().getID() == id) {
                return prescription;
            }
        }
        // If no Prescription found, return null
        return null;
    }

    // Method to update an existing Prescription
    public void update_Prescription(Prescription updatedPrescription) {
        for (int i = 0; i < Prescription_List.size(); i++) {
            Prescription prescription = Prescription_List.get(i);
            if (prescription.getPatient().getID() == updatedPrescription.getPatient().getID()) {
                Prescription_List.set(i, updatedPrescription);
                System.out.println("pRESCRIPTION updated: " + updatedPrescription);
                return;
            }
        }
    }

    // Method to delete a Prescription by Patient ID
    public void delete_Prescription(int id) throws NotFoundException {
        Prescription prescription = getPrescription(id);
        Prescription_List.remove(prescription);
    }
}