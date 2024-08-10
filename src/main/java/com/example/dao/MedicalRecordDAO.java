/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// This is a standard Java package declaration
package com.example.dao;

// Import statements for the required classes
import com.example.model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.NotFoundException;
import com.example.model.Patient;

// This class defines a Data Access Object (DAO) for managing MedicalRecord objects
public class MedicalRecordDAO {

    // Declare a static list to hold all MedicalRecord objects
    private static final List<MedicalRecord> Medical_Records = new ArrayList<>();

    // Get a list of all Patients from the PatientDAO
    static List<Patient> All_Records = PatientDAO.getAllPatients();

    // Static initializer block to add some sample MedicalRecord objects
    static {
        Medical_Records.add(new MedicalRecord(All_Records.get(1).getID(), 1, "fever", "Treatment01", "Data01"));
        Medical_Records.add(new MedicalRecord(All_Records.get(1).getID(), 2, "fever", "Treatment02", "Data02"));
        Medical_Records.add(new MedicalRecord(All_Records.get(0).getID(), 3, "cough", "Treatment03", "Data03"));
        Medical_Records.add(new MedicalRecord(All_Records.get(0).getID(), 4, "fever", "Treatment04", "Data04"));
    }

    // Method to retrieve all MedicalRecords
    public List<MedicalRecord> getAllMedicalRecords() {
        return Medical_Records;
    }

    // Method to add a new MedicalRecord
    public void Add_MedicalRecord(MedicalRecord medicalRecord) {
        Medical_Records.add(medicalRecord);
    }

    // Update method (not implemented)
    public void Update_MedicalRecord(int id, MedicalRecord updatedMedicalRecord) throws NotFoundException {
        MedicalRecord Medical_Records = getMedicalRecord(id);
    }

    // Delete method to remove a MedicalRecord by ID
    public void Delete_MedicalRecord(int id) throws NotFoundException {
        MedicalRecord medicalRecord = getMedicalRecord(id);
        Medical_Records.remove(medicalRecord);
    }

    // Helper method to retrieve a MedicalRecord by ID
    public MedicalRecord getMedicalRecord(int id) {
        int i = 0;
        for (MedicalRecord medicalRecord : Medical_Records) {
            if (medicalRecord.getPatientId() == id) {
                return medicalRecord;
            }
            i++;
        }
        return null;
    }

    // Method to retrieve all MedicalRecords for a specific Patient ID
    public List<MedicalRecord> getMedicalRecords(int id) {
        List<MedicalRecord> matchingRecords = new ArrayList<>();
        for (MedicalRecord medicalRecord : Medical_Records) {
            if (medicalRecord.getPatientId() == id) {
                matchingRecords.add(medicalRecord);
            }
        }
        return matchingRecords;
    }
}